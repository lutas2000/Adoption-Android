package com.demo.lutas.adoption.ui.home

import com.demo.lutas.adoption.model.Animal

sealed class AnimalsState {
    object Loading: AnimalsState()
    object Reloading: AnimalsState()
    class Succeed(val animals: List<Animal>): AnimalsState()
    class Error(val error: Exception): AnimalsState()
}