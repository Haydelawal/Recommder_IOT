package com.example.temi.repository

import com.example.temi.Phonebook
import kotlinx.coroutines.flow.Flow


interface Abstract {

    suspend fun savePhoneBook(phonebook: Phonebook)

    suspend fun getPhoneBook(): Flow<Phonebook>
}