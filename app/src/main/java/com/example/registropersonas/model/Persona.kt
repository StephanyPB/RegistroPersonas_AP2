package com.example.registropersonas.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Personas")
data class Persona (
    @PrimaryKey(autoGenerate = true)
    val personaId: Int,
    val nombre: String,
    val balance: Float
)