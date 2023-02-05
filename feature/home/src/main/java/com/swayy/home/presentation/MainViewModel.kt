package com.swayy.home.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.swayy.core_database.models.MpesaMessage
import com.swayy.core_database.repository.MessagesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val messagesRepository: MessagesRepository) :
    ViewModel() {
    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _groupedMessages = MutableLiveData<List<MpesaMessage>>()
    val groupedMessages = _groupedMessages

    fun getMessages() {
        viewModelScope.launch {
            _loading.value = true
            messagesRepository.fetchMessages()
            _groupedMessages.value = messagesRepository.getMessages()
            _loading.value = false
        }
    }
}