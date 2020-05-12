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
        @Query("\$filter") filter: String?
    ): List<Animal>
}