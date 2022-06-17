package com.hayde117.muheez.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.hayde117.muheez.R
import com.hayde117.muheez.activity.*
import com.hayde117.muheez.databinding.FragmentRecBinding


class RecFragment : Fragment() {

    private var _binding: FragmentRecBinding? = null

    private val binding get() = _binding!!



    override fun onResume() {
        super.onResume()
        val languages = resources.getStringArray(R.array.languages)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, languages)

        binding.autoCompleteTextView.setAdapter(arrayAdapter)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRecBinding.inflate(inflater, container, false)
        binding.buttonClick.setOnClickListener {

            val selectedLanguage= binding.autoCompleteTextView.text.toString()

            val intent1 = Intent(context, CategoryOneActivity::class.java)
            val intent2 = Intent(context, CategoryTwoActivity::class.java)

            val intent3 = Intent(context, CategoryThreeActivity::class.java)
            val intent4 = Intent(context, CategoryFourActivity::class.java)

            val intent5 = Intent(context, CategoryFiveActivity::class.java)
            val intent6 = Intent(context, CategorySixActivity::class.java)

            val intent7 = Intent(context, CategorySevenActivity::class.java)




            when (selectedLanguage) {

                "Transportation" -> startActivity(intent2)
                "Health Care" -> startActivity(intent3)

                "Agriculture" -> startActivity(intent4)
                "Energy" -> startActivity(intent5)




                "Smart-Cities" -> startActivity(intent6)
                "Home" -> startActivity(intent7)


                else -> {
                    startActivity(intent1)
                }
            }

        }
        return binding.root


    }

//    private suspend fun applyAnimations() {
//        binding.textView14.animate().alpha(0f).duration = 400L
//        binding.buttonClick.animate().alpha(0f).duration = 400L
//
//        binding.textView15.animate()
//            .alpha(0f).translationXBy(1200f)
//            .duration = 400L
//
//        binding.textInputLayout.animate()
//            .alpha(0f).translationXBy(-1200f)
//            .duration = 400L
//
//        delay(300)
//
//
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}