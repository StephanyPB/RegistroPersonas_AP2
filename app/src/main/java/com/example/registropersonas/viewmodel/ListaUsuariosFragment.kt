package com.example.registropersonas.viewmodel

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.registropersonas.R
import com.example.registropersonas.databinding.ListaUsuariosFragmentBinding
import com.example.registropersonas.databinding.UsuariosFragmentBinding
import com.example.registropersonas.model.Persona
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ListaUsuariosFragment : Fragment() {

    private  val viewModel : UsuariosViewModel by viewModels()
    private lateinit var binding : ListaUsuariosFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ListaUsuariosFragmentBinding.inflate(inflater,container,false)

        val adapter = UsuarioAdapter(){
            onUsuarioClicked(it)
        }
        binding.usuariosRecyclerView.adapter = adapter

        lifecycleScope.launch {
            viewModel.personas.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collect { lista ->
                    adapter.submitList(lista)
                }
        }

        binding.guardarButton.setOnClickListener{
            onUsuarioClicked()
        }
        return binding.root
    }

    private fun onUsuarioClicked(persona: Persona?= null) {
        val action = ListaUsuariosFragmentDirections.actionToUsuarioFragment(persona)
        findNavController().navigate(action)
    }
}