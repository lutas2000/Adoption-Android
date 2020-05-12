package com.demo.lutas.adoption.remote

import com.demo.lutas.adoption.model.Animal
import retrofit2.http.GET
import retrofit2.http.Query

interface AdoptionService {

    @GET("/Service/OpenData/TransService.aspx")
    suspend fun fetchAnimals(
        @Query("UnitId") unitId: String,
        @Query("\$top") top: Int?,
        @Query("\$skip") skip: Int?,
        @Query("animal_kind") animalKind: String?,
        @Query("animal_sex") animalSex: String?,
        @Query("animal_sterilization") animalSterilization: String?,
        @Query("animal_age") animalAge: String?,
        @Query("animal_bodytype") animalBodyType: String?,
        @Query("animal_area_pkid") animalAreaId: Int?
    ): List<Animal>
}