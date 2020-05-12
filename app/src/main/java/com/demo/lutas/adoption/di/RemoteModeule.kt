package com.demo.lutas.adoption.di

import com.demo.lutas.adoption.remote.AdoptionService
import com.demo.lutas.adoption.remote.ApiClient
import org.koin.dsl.module

val remoteModule = module {
    single { ApiClient() }
    single { createService<AdoptionService>(get()) }
}

private inline fun <reified T> createService(client: ApiClient): T {
    return client.createService(T::class.java)
}