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
    private var lastFilter: AdoptionRepository.Filter? = AdoptionRepository.Filter()

    fun fetchAnimals(filter: AdoptionRepository.Filter?) {
        if (lastFilter == filter) return
        lastFilter = filter
        fetchAnimals(0, filter, AnimalsState.Loading)
    }

    fun reloadAnimals() {
        fetchAnimals(0, lastFilter, AnimalsState.Reloading)
    }

    fun fetchMoreAnimals() {
        val skip = currentAnimals.size
        fetchAnimals(skip, lastFilter, AnimalsState.Loading)
    }

    private fun fetchAnimals(
        skip: Int,
        filter: AdoptionRepository.Filter?,
        loadingState: AnimalsState
    ) {
        val oldData = currentAnimals
        _animalsState.value = loadingState
        viewModelScope.launch {
            try {
                val response = adoptionRepository.fetchAnimals(20, skip, filter)
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