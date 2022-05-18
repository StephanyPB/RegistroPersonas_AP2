package com.example.registropersonas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.registropersonas.databinding.ActivityMainBinding
import com.example.registropersonas.model.Persona
import com.example.registropersonas.viewmodel.UsuariosViewModel
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    public lateinit var binding: ActivityMainBinding
    public val viewModel: UsuariosViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lista_usuarios_fragment)

    }
}