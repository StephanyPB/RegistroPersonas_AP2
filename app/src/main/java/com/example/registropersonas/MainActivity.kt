package com.example.registropersonas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.registropersonas.databinding.ActivityMainBinding
import com.example.registropersonas.model.Persona
import com.example.registropersonas.viewmodel.UsuarioViewModel
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: UsuarioViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.guardarButton.setOnClickListener {
            viewModel.guardar(
                Persona(
                    0,
                    binding.nombreEditText.text.toString(),
                    binding.balanceEditText.floatValue()
                )
            )
        }
            viewModel.guardado.observe(this) {
                if (it) {
                    Snackbar.make(binding.balanceEditText, "Guardado Exitoso!", Snackbar.LENGTH_LONG).show()
                }
            }
    }
        fun TextInputEditText.floatValue() = text.toString().toFloatOrNull() ?: 0.0f
}