package com.demo.lutas.adoption.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.lutas.adoption.repository.AdoptionRepository
import kotlinx.coroutines.launch

class HomeViewModel(
    private val adoptionRepository: AdoptionRepository
) : ViewModel() {

    private val _animalsState = MutableLiveData<AnimalsState>()
    val animalsState: LiveData<AnimalsState>
        get() = _animalsState

    fun fetchAnimals() {
        _animalsState.value = AnimalsState.Loading
        viewModelScope.launch {
            try {
                val response = adoptionRepository.fetchAnimals(top = 20)
                _animalsState.value = AnimalsState.Succeed(response)
            } catch (e: Exception) {
                _animalsState.value = AnimalsState.Error(e)
            }
        }
    }
}