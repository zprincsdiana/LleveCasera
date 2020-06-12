package com.anys.lleve_casera_dv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SingInActivity extends AppCompatActivity {

    EditText txt_nom_reg,txt_ape_reg,txt_cel_reg,txt_email_reg,txt_pass_reg;
    Button btn_registro,btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in);

        txt_nom_reg = findViewById(R.id.txt_nom_r);
        txt_ape_reg = findViewById(R.id.txt_ape_r);
        txt_cel_reg = findViewById(R.id.txt_cel_r);
        txt_email_reg = findViewById(R.id.txt_email_r);
        txt_pass_reg = findViewById(R.id.txt_psw_r);

        btn_registro = findViewById(R.id.btn_registro_r);
        btn_registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //agregarUsuario();

                String nombre = txt_nom_reg.getText().toString();
                String apellido = txt_ape_reg.getText().toString();
                String celular = txt_cel_reg.getText().toString();
                String correo = txt_email_reg.getText().toString();
                String password = txt_pass_reg.getText().toString();

                    Toast.makeText(getApplicationContext(),"Registro realizado correctamente ",Toast.LENGTH_LONG).show();

                    /*Toast.makeText(getApplicationContext(),"Ha ocurrido un error , estamos verificando",Toast.LENGTH_LONG).show();*/


            }
        });


        btn_back = findViewById(R.id.btn_back_r);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }



}
