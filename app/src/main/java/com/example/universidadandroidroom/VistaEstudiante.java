package com.example.universidadandroidroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.universidadandroidroom.entidades.Estudiante;
import com.example.universidadandroidroom.repositorio.DbConexion;

public class VistaEstudiante extends AppCompatActivity {
    public static DbConexion dbConexion;
    private EditText matricula, nombre, carrera;
    private Button actualizar, borrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_estudiante);

        dbConexion = Room.databaseBuilder(getApplicationContext(),DbConexion.class,"escueladb4").allowMainThreadQueries().build();

        matricula = findViewById(R.id.detalleMatricula);
        nombre = findViewById(R.id.detalleNombre);
        carrera = findViewById(R.id.detalleCarrera);
        actualizar = findViewById(R.id.detalleActualizar);
        borrar = findViewById(R.id.detalleEliminar);


        Intent intent = getIntent();
        nombre.setText(intent.getStringExtra(ListaEstudiantes.EXTRA_NOMBRE));
        matricula.setText(intent.getStringExtra(ListaEstudiantes.EXTRA_MATRICULA));
        carrera.setText(intent.getStringExtra(ListaEstudiantes.EXTRA_CARRERA));

        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Estudiante estudiante = new Estudiante();
                    estudiante.setMatricula(matricula.getText().toString());
                    estudiante.setNombre(nombre.getText().toString());
                    estudiante.setCarrera(carrera.getText().toString());

                    VistaEstudiante.dbConexion.estudianteDao().actualzarEstudiante(estudiante);

                Toast.makeText(getApplicationContext(), "Los datos del estudiante fueron Actualizados con exito!", Toast.LENGTH_SHORT).show();

            }
        });

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Estudiante estudiante = new Estudiante();
                estudiante.setMatricula(matricula.getText().toString());
                estudiante.setNombre(nombre.getText().toString());
                estudiante.setCarrera(carrera.getText().toString());

                VistaEstudiante.dbConexion.estudianteDao().borrarEstudiante(estudiante);

                Toast.makeText(getApplicationContext(), "El estudiante fue borrado con  exito!", Toast.LENGTH_SHORT).show();

                matricula.setText("");
                nombre.setText("");
                carrera.setText("");
            }
        });


    }
}
