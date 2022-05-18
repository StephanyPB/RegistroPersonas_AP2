package com.example.registropersonas.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.registropersonas.data.UsuarioDao
import com.example.registropersonas.model.Persona
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

import javax.inject.Inject

@HiltViewModel
class UsuariosViewModel  @Inject constructor(
    val usuarioDao : UsuarioDao
): ViewModel() {

    val personas: Flow<List<Persona>>
    get() = usuarioDao.GetLista()

    public val _guardado = MutableLiveData(false)
    val guardado: LiveData<Boolean> get() = _guardado

    fun guardar(persona: Persona){
        viewModelScope.launch {
            usuarioDao.Insertar(persona)
            _guardado.value=true
        }
    }

}