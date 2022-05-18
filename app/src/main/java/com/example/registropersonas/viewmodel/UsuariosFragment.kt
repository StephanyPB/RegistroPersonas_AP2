package com.example.registropersonas.viewmodel

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.registropersonas.R
import com.example.registropersonas.databinding.UsuariosFragmentBinding
import com.example.registropersonas.model.Persona
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import dagger.hilt.android.AndroidEntryPoint

class UsuariosFragment : Fragment() {

    private val viewModel: UsuariosViewModel by viewModels()
    private lateinit var binding: UsuariosFragmentBinding

    //atrapar el usuario pasado por argumento
    private val args: UsuariosFragmentArgs by navArgs()

    private var usuarioId: Int  = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  UsuariosFragmentBinding.inflate(inflater, container, false)

        LlenarCampos()

        binding.guardarButton.setOnClickListener{
            viewModel.guardar(Persona(
                0,
                binding.nombreEditText.text.toString(),
                binding.emailEditText.text.toString(),
                binding.ocupacionIdEditText.text.toString().toInt(),
                binding.salarioEditText.floatValue()
            )
          )
        }

        viewModel.guardado.observe(viewLifecycleOwner) {
            if (it) {
                Snackbar.make(binding.salarioEditText, "Guardado exitosamente!", Snackbar.LENGTH_LONG).show()
                findNavController().navigateUp()
            }
        }
        return binding.root
    }

    private fun LlenarCampos() {
        val persona: Persona? = args.usuario
        persona?.let {
            usuarioId = it.personaId
            binding.nombreEditText.setText(it.nombre)
            binding.emailEditText.setText(it.email)
            binding.salarioEditText.setText(it.salario.toString())
        }
    }

    fun TextInputEditText.floatValue() = text.toString().toFloatOrNull() ?: 0.0f
}