package com.demo.lutas.adoption.repository

import com.demo.lutas.adoption.model.Animal
import com.demo.lutas.adoption.remote.AdoptionService

class AdoptionRepository(
    private val adoptionService: AdoptionService
) {

    suspend fun fetchAnimals(
        top: Int? = null,
        skip: Int? = null,
        filter: String? = null
    ): List<Animal> {
        val unitId = "QcbUEzN6E6DL"
        return adoptionService.fetchAnimals(unitId, top, skip, filter)
    }
}