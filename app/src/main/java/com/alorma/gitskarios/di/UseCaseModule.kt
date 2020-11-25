package com.alorma.gitskarios.di

import com.alorma.gitskarios.domain.ObtainUserNotificationsUseCase
import org.koin.dsl.module

object UseCaseModule {
    operator fun invoke() = module {
        factory { ObtainUserNotificationsUseCase(get()) }
    }
}