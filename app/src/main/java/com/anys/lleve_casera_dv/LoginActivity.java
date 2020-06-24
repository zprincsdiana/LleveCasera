package com.anys.lleve_casera_dv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    private TextInputLayout celu_validacion,contra_validacion;
    TextInputEditText txt_cel, txt_psw;
    Button btn_login_star,btn_login_registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        /*Son del TextInputLayout*/
        celu_validacion = findViewById(R.id.txt_celular);
        contra_validacion = findViewById(R.id.txt_contra);
        /*Son de TextInputEditText*/
        txt_cel= findViewById(R.id.txt_cel_i);
        txt_psw= findViewById(R.id.txt_psw_i);
        /*Para validar .. .debe ir como cond antes de dar funcion al boton iniciar sesion */
        confirmar();



        /*Funcion a los botones iniciar sesion o registrarse*/
        btn_login_star= findViewById(R.id.btn_login_start);
        btn_login_star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String celular = txt_cel.getText().toString();
                String clave = txt_psw.getText().toString();

                    Toast.makeText(getApplicationContext(), "!Bienvenido!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, PrincipalActivity.class));

                    /*Toast.makeText(getApplicationContext(), "Número o contraseña incorrectos, verifique sus datos. O cree una cuenta.", Toast.LENGTH_SHORT).show();
                    txt_cel.setText("");
                    txt_psw.setText("");*/


            }
        });

        btn_login_registrar = findViewById(R.id.btn_redi_registro);
        btn_login_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,SingInActivity.class);
                startActivity(intent);

            }
        });

    }

    /*Para validar los datos con el TextInputLayout*/
    private boolean validarCelular(){
        String num = celu_validacion.getEditText().getText().toString().trim();

        if (num.isEmpty()){
            celu_validacion.setError("Este espacio no puede estar en blanco");
            
            return false;
        }else if(num.length()>9) {
            celu_validacion.setError("Ingrese un número de celular válido");
            return false;
        }else {
            celu_validacion.setError(null);
            return true;
        }
    }
    private boolean validarPass(){
        String pass = contra_validacion.getEditText().getText().toString().trim();

        if (pass.isEmpty()){
            contra_validacion.setError("Este espacio no puede estar en blanco");
            return false;
        }else {
            contra_validacion.setError(null);
            return true;
        }
    }

    public void confirmar(){
        if (!validarCelular() | !validarPass()){
            return;
        }
    }




}
