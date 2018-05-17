package com.henriquez.personas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.henriquez.personas.Entidades.DBHelper;

public class MainActivity extends AppCompatActivity {

    private Button btn_registrar;
    private Button btn_consultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarControles();
        DBHelper.getIntence(this);

        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),RegistrarActivity.class);
                startActivity(intent);
            }
        });

        btn_consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ModificarActivity.class);
                startActivity(intent);
            }
        });

    }

    public void inicializarControles(){
        btn_registrar=findViewById(R.id.MostrarRegistro);
        btn_consultar=findViewById(R.id.consultar_usuario);
    }

}
