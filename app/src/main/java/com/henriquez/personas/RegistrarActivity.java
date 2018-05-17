package com.henriquez.personas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.henriquez.personas.Datos.Persona;
import com.henriquez.personas.Entidades.DBHelper;

public class RegistrarActivity extends AppCompatActivity {

    private EditText txtId;
    private EditText txtNombre;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        //inicializamos los controles
        inicializarControles();

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = DBHelper.myDB.add(new Persona(txtId.getText().toString(),txtNombre.getText().toString()));
                if (flag){
                    Log.d("Edit",txtNombre.getText().toString());
                }
            }
        });

    }

    public void inicializarControles(){
        txtId=findViewById(R.id.txtid);
        txtNombre=findViewById(R.id.txtnombre);
        btnEnviar=findViewById(R.id.btnregistrar);
    }

}
