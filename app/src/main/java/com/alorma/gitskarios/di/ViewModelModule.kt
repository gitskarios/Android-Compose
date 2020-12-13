package com.alorma.gitskarios.di

import com.alorma.gitskarios.screen.notifications.NotificationsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ViewModelModule {

    operator fun invoke() = module {
        viewModel {
            NotificationsViewModel(get())
        }
    }
}