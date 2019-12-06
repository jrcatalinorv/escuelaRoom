package com.example.universidadandroidroom.repositorio;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.universidadandroidroom.entidades.Carreras;
import com.example.universidadandroidroom.entidades.Estudiante;

@Database(entities = {Estudiante.class,Carreras.class}, version = 1)
public abstract class DbConexion extends RoomDatabase {

    public abstract EstudianteDao estudianteDao();



}
