package com.alorma.gitskarios.screen.notifications

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alorma.gitskarios.domain.ObtainUserNotificationsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NotificationsViewModel(
    private val obtainUserNotificationsUseCase: ObtainUserNotificationsUseCase,
) :
    ViewModel() {

    private val _userState: MutableStateFlow<NotificationsState> = MutableStateFlow(
        NotificationsState.Loading
    )
    val userState: StateFlow<NotificationsState> = _userState

    fun load() {
        viewModelScope.launch {
            val events = obtainUserNotificationsUseCase.loadNotifications()

            _userState.value = NotificationsState.Data(
                events = events
            )
        }
    }
}