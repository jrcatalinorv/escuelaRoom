package com.example.universidadandroidroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnEstudiantes, btnCarreras, btnMaterias;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEstudiantes = findViewById(R.id.btnEstudiantes);
        btnCarreras = findViewById(R.id.btnCarreras);
        btnMaterias = findViewById(R.id.btnMateria);


        btnEstudiantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaestudiantes();
            }
        });

    }

public void listaestudiantes(){
    Intent intent = new Intent(this, ListaEstudiantes.class);
    startActivity(intent);
}

}
