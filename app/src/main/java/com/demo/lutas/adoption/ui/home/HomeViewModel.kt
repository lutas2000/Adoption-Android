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
    private val currentAnimals
        get() = (_animalsState.value as? AnimalsState.Succeed)?.animals ?: emptyList()

    fun fetchAnimals() {
        fetchAnimals(0)
    }

    fun fetchMoreAnimals() {
        val skip = currentAnimals.size
        fetchAnimals(skip)
    }

    private fun fetchAnimals(skip: Int) {
        val oldData = currentAnimals
        _animalsState.value = AnimalsState.Loading
        viewModelScope.launch {
            try {
                val response = adoptionRepository.fetchAnimals(top = 20, skip = skip)
                val newData = if (skip > 0) {
                    oldData + response
                } else {
                    response
                }
                _animalsState.value = AnimalsState.Succeed(newData)
            } catch (e: Exception) {
                _animalsState.value = AnimalsState.Error(e)
            }
        }
    }

}