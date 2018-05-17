package com.henriquez.personas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.henriquez.personas.Datos.Persona;
import com.henriquez.personas.Entidades.DBHelper;

import java.util.List;

public class ModificarActivity extends AppCompatActivity {

    private EditText id;
    private EditText nombre;
    private Button btnbuscar;
    private Button btneliminar;
    private Button btnactualizar;
    private Button btnlimpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);

        //seteamos elementos
        inicializarControles();

        btnbuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Persona p = DBHelper.myDB.findUser(id.getText().toString());
                if (p==null){
                    Toast.makeText(getApplicationContext(),"El usuario no fue encontrado",Toast.LENGTH_SHORT).show();
                    Limpiar();
                }
                else {
                    nombre.setText(p.getNombre());
                }
            }
        });

        btnactualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper.myDB.editUser(new Persona(id.getText().toString(),nombre.getText().toString()));
            }
        });

        btneliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper.myDB.deleteUser(id.getText().toString());
                Limpiar();
            }
        });

        btnlimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Limpiar();
            }
        });

    }

    public void inicializarControles(){
        id=findViewById(R.id.txtidM);
        nombre=findViewById(R.id.txtnombreM);
        btneliminar=findViewById(R.id.btneliminar);
        btnactualizar=findViewById(R.id.btnactualizar);
        btnlimpiar=findViewById(R.id.btnlimpiar);
        btnbuscar=findViewById(R.id.btnmodificar);
    }

    public void Limpiar(){
        nombre.setText("");
        id.setText("");
    }

}
