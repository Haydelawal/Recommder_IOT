package com.example.temi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.temi.Phonebook
import com.example.temi.repository.ImplRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect


@HiltViewModel
class ActivityViewModel @Inject constructor(private  val implRepository: ImplRepository): ViewModel() {

    var phone : MutableLiveData<String> = MutableLiveData("")
    var address : MutableLiveData<String> = MutableLiveData("")
    var name : MutableLiveData<String> = MutableLiveData("")

    var phonebook : MutableLiveData<Phonebook> = MutableLiveData()

    ///// me

    fun showTheData(): LiveData<Phonebook> {
        return phonebook
    }

    /////
    fun saveData(){
        viewModelScope.launch(Dispatchers.IO) {
            implRepository.savePhoneBook(
                Phonebook(
                    phone = phone.value!!,
                    address = address.value!!,
                    name = name.value!!
                )
            )
        }
    }

    fun retrieveDate(){
        viewModelScope.launch(Dispatchers.IO) {
            implRepository.getPhoneBook().collect {
                phonebook.postValue(it)
            }
        }
    }
}