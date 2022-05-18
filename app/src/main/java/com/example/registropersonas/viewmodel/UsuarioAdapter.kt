package com.example.registropersonas.viewmodel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.registropersonas.databinding.RowUsuarioBinding
import com.example.registropersonas.model.Persona
import dagger.hilt.android.AndroidEntryPoint


class UsuarioAdapter(
    private var onItemClicked:((Personas:Persona)-> Unit)

): ListAdapter<Persona, UsuarioAdapter.UsuarioViewHolder>(UsuarioDiffCallBack()) {

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int){
        val item = getItem(position)

        holder.bind(item)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewTipe:Int): UsuarioViewHolder{
       val binding = RowUsuarioBinding
           .inflate(LayoutInflater.from(parent.context), parent, false)

        return UsuarioViewHolder(binding)
    }

    inner class UsuarioViewHolder(private var binding: RowUsuarioBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Persona) {
            binding.nombresTextView.text = item.nombre.toString()
            binding.emailTextView.text = item.email.toString()
            binding.SalarioTextView.text = item.salario.toString()

            binding.root.setOnClickListener {
                onItemClicked(item)
        }
     }
   }
}
class UsuarioDiffCallBack: DiffUtil.ItemCallback<Persona>() {
    override fun areItemsTheSame(oldItem: Persona, newItem: Persona): Boolean {
        return oldItem.personaId == newItem.personaId
    }

    override fun areContentsTheSame(oldItem: Persona, newItem: Persona): Boolean {
        return oldItem == newItem
    }
}