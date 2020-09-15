package app.kushagra.takeoff.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BaseViewModel : ViewModel() {

    val inProgress by lazy { MutableLiveData<Boolean>() }
    val error by lazy { MutableLiveData<Throwable>() }

    override fun onCleared() {
        super.onCleared()
        inProgress.value = false
    }

    fun onErrors(throwable: Throwable){
        inProgress.value = false
        error.value = throwable
    }

}