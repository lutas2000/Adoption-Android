package com.demo.lutas.adoption.di

import com.demo.lutas.adoption.repository.AdoptionRepository
import com.demo.lutas.adoption.ui.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { AdoptionRepository(get()) }

    viewModel { HomeViewModel(get()) }
}