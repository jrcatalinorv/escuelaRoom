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

public class FormularioEstudiantes extends AppCompatActivity {
    public static DbConexion dbConexion;
    private EditText etMatricula, etNombre, etCarrera;
    private Button btnCancelar, btnAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_estudiantes);

        dbConexion = Room.databaseBuilder(getApplicationContext(),DbConexion.class,"escueladb4").allowMainThreadQueries().build();

        etMatricula = findViewById(R.id.feMatricula);
        etNombre = findViewById(R.id.feNombre);
        etCarrera = findViewById(R.id.feCarrera);
        btnAceptar = findViewById(R.id.feGuardar);
        btnCancelar = findViewById(R.id.feCancelar);

    btnAceptar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Estudiante estudiante = new Estudiante();
                estudiante.setMatricula(etMatricula.getText().toString());
                estudiante.setNombre(etNombre.getText().toString());
                estudiante.setCarrera(etCarrera.getText().toString());

            FormularioEstudiantes.dbConexion.estudianteDao().agregarEstudiante(estudiante);

           Toast.makeText(getApplicationContext(), "El estudiante fue agregado con exito!", Toast.LENGTH_SHORT).show();


            etMatricula.setText("");
            etNombre.setText("");
            etCarrera.setText("");
        }
    });

    btnCancelar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            listaestudiantes();
        }
    });

    }

    public void listaestudiantes(){
        Intent intent = new Intent(this, ListaEstudiantes.class);
        startActivity(intent);
    }
}
