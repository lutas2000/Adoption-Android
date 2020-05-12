package com.demo.lutas.adoption

import androidx.lifecycle.ViewModel
import com.demo.lutas.adoption.repository.AdoptionRepository

class MainViewModel : ViewModel() {
    var animalFilter: AdoptionRepository.Filter? = null

}