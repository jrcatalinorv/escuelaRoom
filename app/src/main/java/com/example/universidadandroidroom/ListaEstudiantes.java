package com.example.universidadandroidroom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.universidadandroidroom.adaptadores.AdaptadorEstudiante;
import com.example.universidadandroidroom.entidades.Estudiante;
import com.example.universidadandroidroom.repositorio.DbConexion;

import java.util.List;

public class ListaEstudiantes extends AppCompatActivity {

    private RecyclerView rvEstudiante;
    private List<Estudiante> estudianteList;
    public static DbConexion dbConexion;
    public static final String EXTRA_NOMBRE ="com.example.universidadandroidroom.EXTRA_NOMBRE";
    public static final String EXTRA_MATRICULA ="com.example.universidadandroidroom.EXTRA_MATRICULA";
    public static final String EXTRA_CARRERA ="com.example.universidadandroidroom.EXTRA_CARRERA";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_estudiantes);

       dbConexion = Room.databaseBuilder(getApplicationContext(),DbConexion.class,"escueladb4").allowMainThreadQueries().build();
       rvEstudiante = findViewById(R.id.rvEstudiantes);
       rvEstudiante.setLayoutManager(new LinearLayoutManager(this));

       estudianteList = dbConexion.estudianteDao().mostrarEstudiantes();
       AdaptadorEstudiante adaptadorEstudiante = new AdaptadorEstudiante(estudianteList);
       adaptadorEstudiante.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               FichaEstuante(estudianteList.get(rvEstudiante.getChildAdapterPosition(view)).getNombre(),
                       estudianteList.get(rvEstudiante.getChildAdapterPosition(view)).getMatricula(),
                       estudianteList.get(rvEstudiante.getChildAdapterPosition(view)).getCarrera());
           }
       });
       rvEstudiante.setAdapter(adaptadorEstudiante);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_estudiante,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item2:
                formularioestudiantes();
                return true;
             default:
                 return super.onOptionsItemSelected(item);
        }
    }


    public void formularioestudiantes(){
        Intent intent = new Intent(this, FormularioEstudiantes.class);
        startActivity(intent);
    }

    public void FichaEstuante(String name, String mat, String carr){
        Intent intent = new Intent(this,VistaEstudiante.class);
        intent.putExtra(EXTRA_NOMBRE,name);
        intent.putExtra(EXTRA_MATRICULA,mat);
        intent.putExtra(EXTRA_CARRERA,carr);
        startActivity(intent);
    }

}
