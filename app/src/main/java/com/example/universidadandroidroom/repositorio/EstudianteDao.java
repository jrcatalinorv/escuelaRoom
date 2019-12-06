package com.example.universidadandroidroom.repositorio;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.universidadandroidroom.entidades.Estudiante;

import java.util.List;

@Dao
public interface EstudianteDao {

    @Insert
    public void agregarEstudiante(Estudiante estudiante);

    @Delete
    public void borrarEstudiante(Estudiante estudiante);

    @Update
    public void actualzarEstudiante(Estudiante estudiante);

    @Query("SELECT * FROM estudiantes")
    public List<Estudiante> mostrarEstudiantes();

    @Query("SELECT * FROM estudiantes WHERE matricula = :matricula " )
    public Estudiante buscarEstudiante(String matricula);

}
