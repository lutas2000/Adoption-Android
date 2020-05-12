package com.demo.lutas.adoption.repository

import com.demo.lutas.adoption.model.Animal
import com.demo.lutas.adoption.remote.AdoptionService

class AdoptionRepository(
    private val adoptionService: AdoptionService
) {

    class Filter (
        val kind: String? = null,
        val sex: String? = null,
        val sterilization: String? = null,
        val age: String? = null,
        val bodyType: String? = null,
        val areaId: Int? = null
    )

    suspend fun fetchAnimals(
        top: Int? = null,
        skip: Int? = null,
        filter: Filter? = null
    ): List<Animal> {
        val unitId = "QcbUEzN6E6DL"
        return adoptionService.fetchAnimals(
            unitId = unitId,
            top = top,
            skip = skip,
            animalKind = filter?.kind,
            animalSex = filter?.sex,
            animalSterilization = filter?.sterilization,
            animalAge = filter?.age,
            animalBodyType = filter?.bodyType,
            animalAreaId = filter?.areaId
        )
    }
}