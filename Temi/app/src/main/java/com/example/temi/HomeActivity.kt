package com.example.temi

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.viewModels
import com.example.temi.databinding.ActivityHomeBinding
import com.example.temi.viewmodel.ActivityViewModel
import com.example.temi.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import org.tensorflow.lite.Interpreter
import java.io.FileInputStream
import java.io.IOException
import java.nio.MappedByteBuffer
import java.nio.channels.FileChannel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import androidx.activity.viewModels
import androidx.lifecycle.LifecycleOwner
import kotlin.properties.Delegates

// import androidx.activity.viewModels
//import com.infinity.preferencesdatastoreexample.databinding.ActivityMainBinding
//import com.infinity.preferencesdatastoreexample.viewmodel.ActivityViewModel
//import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

//    private lateinit var value: Value

    private var _binding: ActivityHomeBinding? = null

    private val binding get() = _binding!!

    private val activityViewModel: ActivityViewModel by viewModels()

    // Name of TFLite model ( in /assets folder ).
    private val MODEL_ASSETS_PATH = "model.tflite"

//    var myResult1 by Delegates.notNull<Int>()

//    val value = Value()

//    var lifecycleOwner: LifecycleOwner = this
//    var viewModel = activityViewModel




    // Max Length of input sequence. The input shape for the model will be ( None , INPUT_MAXLEN ).
    private val INPUT_MAXLEN = 171

    private var tfLiteInterpreter : Interpreter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lifecycleOwner = this
        binding.viewModel = activityViewModel




        val classifier = Classifier( this , "word_dict.json" , INPUT_MAXLEN )
        // Init TFLiteInterpreter
        tfLiteInterpreter = Interpreter( loadModelFile() )

        // Start vocab processing, show a ProgressDialog to the user.
        val progressDialog = ProgressDialog( this )
        progressDialog.setMessage( "Parsing word_dict.json ..." )
        progressDialog.setCancelable( false )
        progressDialog.show()
        classifier.processVocab( object: Classifier.VocabCallback {
            override fun onVocabProcessed() {
                // Processing done, dismiss the progressDialog.
                progressDialog.dismiss()
            }
        })

        binding.classifyButton.setOnClickListener {

            val message = binding.messageText.text.toString().lowercase().trim()
            if ( !TextUtils.isEmpty( message ) ){
                // Tokenize and pad the given input text.
                val tokenizedMessage = classifier.tokenize( message )
                val paddedMessage = classifier.padSequence( tokenizedMessage )

                val results = classifySequence( paddedMessage )
                val class1 = results[0]
                val class2 = results[1]
               binding.resultText.text =   "$class2"

                binding.resultText2.text =   "$class1"

                activityViewModel.saveData()

//               var value1 = class1.toInt()
//               var value2 = class2.toInt()


                val intent = Intent(this, AnimationActivity::class.java)

                startActivity(intent)

//                var user = User(value1,value2)





            } else{
                Toast.makeText( this@HomeActivity, "Please enter a message.", Toast.LENGTH_LONG).show();
            }

        }


    }

//    class User(var first: Int, var second: Int)
//    {
//
//    }



    @Throws(IOException::class)
    private fun loadModelFile(): MappedByteBuffer {
        val assetFileDescriptor = assets.openFd(MODEL_ASSETS_PATH)
        val fileInputStream = FileInputStream(assetFileDescriptor.fileDescriptor)
        val fileChannel = fileInputStream.channel
        val startOffset = assetFileDescriptor.startOffset
        val declaredLength = assetFileDescriptor.declaredLength
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength)
    }

    // Perform inference, given the input sequence.
    private fun classifySequence (sequence : IntArray ): FloatArray {
        // Input shape -> ( 1 , INPUT_MAXLEN )
        val inputs : Array<FloatArray> = arrayOf( sequence.map { it.toFloat() }.toFloatArray() )
        // Output shape -> ( 1 , 2 ) ( as numClasses = 2 )
        val outputs : Array<FloatArray> = arrayOf( FloatArray( 2 ) )
        tfLiteInterpreter?.run( inputs , outputs )
        return outputs[0]
    }



}