package com.example.registropersonas.di

import android.content.Context
import androidx.room.Room
import com.example.registropersonas.data.PersonasDb
import com.example.registropersonas.data.UsuarioDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun ProvideUsuarioDb(@ApplicationContext context: Context): PersonasDb {
        val DATABASE_NAME = "PersonasDb"
        return Room.databaseBuilder(
            context,
            PersonasDb::class.java,
            DATABASE_NAME       )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun ProvideUsuarioDaO(personasDb: PersonasDb): UsuarioDao {
        return personasDb.usuarioDao
    }
}