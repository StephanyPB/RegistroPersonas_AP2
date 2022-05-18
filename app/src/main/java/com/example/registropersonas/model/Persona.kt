package com.example.registropersonas.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "Personas")
data class Persona (
    @PrimaryKey(autoGenerate = true)
    val personaId: Int,
    val nombre: String,
    val email: String,
    val ocupacionId: Int,
    val salario: Float,
): Parcelable
