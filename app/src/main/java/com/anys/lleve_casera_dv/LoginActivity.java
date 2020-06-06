package com.anys.lleve_casera_dv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;

public class LoginActivity extends AppCompatActivity {

    EditText txt_cel, txt_psw;
    Button btn_login_star;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txt_cel=(EditText) findViewById(R.id.txt_cel_i);
        txt_psw=(EditText) findViewById(R.id.txt_psw_i);
        btn_login_star= (Button) findViewById(R.id.btn_login_start);
        btn_login_star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String celular = txt_cel.getText().toString();
                String clave = txt_psw.getText().toString();
                C_Usuario user= new C_Usuario();
                if(user.getByPhonePsw(celular,clave)==1){
                    Toast.makeText(getApplicationContext(), "!Bienvenido!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, PrincipalActivity.class));
                }else{
                    Toast.makeText(getApplicationContext(), "Número o contraseña incorrectos, verifique sus datos. O cree una cuenta.", Toast.LENGTH_SHORT).show();
                    txt_cel.setText("");
                    txt_psw.setText("");
                }
            }
        });
    }

    public Connection conexionBD(){
        Connection conexion = null;
            try {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
                conexion= DriverManager.getConnection("jdbc:jtds:sqlserver://localhost;databaseName=DBLLeveCasera;integrate Security=true");
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        return conexion;
    }

}
