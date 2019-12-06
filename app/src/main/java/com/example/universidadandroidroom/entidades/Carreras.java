package com.example.universidadandroidroom.entidades;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "carreras")
public class Carreras {

    @PrimaryKey
    private int id;

    private String carrera;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}
