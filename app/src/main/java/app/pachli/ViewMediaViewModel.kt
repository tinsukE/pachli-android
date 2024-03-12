package app.pachli

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow

class ViewMediaViewModel : ViewModel() {
    private val _toolbarVisibility = MutableStateFlow(true)
    /** Emits Toolbar visibility changes */
    val toolbarVisibility: StateFlow<Boolean> get() = _toolbarVisibility.asStateFlow()

    private val _toolbarMenuInteraction = MutableSharedFlow<Unit>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
    )
    /** Emits whenever a Toolbar menu interaction happens (ex: open overflow menu, item action) */
    val toolbarMenuInteraction: SharedFlow<Unit> get() = _toolbarMenuInteraction.asSharedFlow()

    /** Convenience getter for the current Toolbar visibility */
    val isToolbarVisible: Boolean
        get() = toolbarVisibility.value

    fun onToolbarVisibilityChange(isVisible: Boolean) {
        _toolbarVisibility.value = isVisible
    }

    fun onToolbarMenuInteraction() {
        _toolbarMenuInteraction.tryEmit(Unit)
    }
}
