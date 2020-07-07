package com.anys.lleve_casera_dv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.anys.lleve_casera_dv.io.response.UsuarioResponse;
import com.anys.lleve_casera_dv.io.usuarioApiAdapter;
import com.anys.lleve_casera_dv.model.Usuario;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    TextInputLayout celu_validacion,contra_validacion;
    EditText txt_cel, txt_psw;
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
              /*  String celularUsuario = txt_cel.getText().toString();
                String contrasenaUsuario = txt_psw.getText().toString();*/

                //Toast.makeText(getApplicationContext(), "cel: "+celularUsuario+ ", contra: "+contrasenaUsuario, Toast.LENGTH_SHORT).show();
                //autenticar el usuario con la base de datos
                autenticarLoginUsuario();

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

    //obtener los datos de la base de datos para comparar

    private void autenticarLoginUsuario(){
        Usuario user= new Usuario();
        String ps = txt_psw.getText().toString().trim();
        user.setContrasenaUsuario(ps);
        user.setCelularUsuario(txt_cel.getText().toString().trim());

        Call<UsuarioResponse> call= usuarioApiAdapter.getApiService().userLogin(user);
        call.enqueue(new UsuariosCallback());

    }

    /*
    No se usa por el momento
    private void obtenerDatosUsuario(ArrayList<Usuario> usuariolist){

        *//*String celular = txt_cel.getText().toString();
        String clave = txt_psw.getText().toString();
        *//*

        List<String> list = new ArrayList<String>();

        for (Usuario u : usuariolist) {
            list.add(u.getCelularUsuario());
            list.add( u.getContrasenaUsuario());

            Log.d("Ditels", " "+u.getContrasenaUsuario());
            Log.d("Ditels", " "+u.getNombreUsuario());
            Log.d("Ditels", " "+u.getCorreoUsuario());
            Log.d("Ditels", " "+u.getCelularUsuario());
            Log.d("Ditels", " "+u.getApellidoUsuario());
            //Toast.makeText(getApplicationContext(), "contra: "+u.getContraseñaUsuario()+" "+ txt_psw.getText().toString(), Toast.LENGTH_SHORT).show();
        }
        String[] val_user = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            val_user[i] = list.get(i);
        }

        //Consultar a la base de datos
        String cel= txt_cel.getText().toString().trim();
        String cla= txt_psw.getText().toString().trim();
        Log.d("Ditels", " "+list.get(1));
        Toast.makeText(getApplicationContext(), "List: "+list.size()+"cel: "+val_user[0]+ ", contra: "+list.get(1), Toast.LENGTH_SHORT).show();
        if(cel.equals(val_user[0]) && cla.equals(val_user[1])){
            //saveLoginSharedPreferences(celular);
            Toast.makeText(getApplicationContext(), R.string.bienvenido, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginActivity.this, PrincipalActivity.class));
        }else{
            Toast.makeText(getApplicationContext(), R.string.login_error, Toast.LENGTH_SHORT).show();
            txt_cel.setText("");
            txt_psw.setText("");
        }

    }*/

    class UsuariosCallback implements Callback<UsuarioResponse> {

        @Override
        public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
        if(response.isSuccessful()){
            UsuarioResponse usuarioResponse= response.body();
            assert usuarioResponse != null;
            if(usuarioResponse.getEstado()==1){
                //No se usa por el momento
                //obtenerDatosUsuario(usuarioResponse.getUsuario());
                Toast.makeText(getApplicationContext(), R.string.bienvenido, Toast.LENGTH_SHORT).show();
               // String celular= txt_cel.getText().toString().trim();
               // String contraseña = txt_psw.getText().toString().trim();
                //saveLoginSharedPreferences(celular, contraseña);
                startActivity(new Intent(LoginActivity.this, PrincipalActivity.class));
                finish();
                //String auten_cel = usuarioResponse.getUsuario().get(1).getCelularUsuario();
            }else{
                //Falta realizar el response de errores
                Toast.makeText(getApplicationContext(), R.string.login_error, Toast.LENGTH_SHORT).show();
                txt_cel.setText("");
                txt_psw.setText("");
            }
        }else{
            Toast.makeText(getApplicationContext(),"Error en el formato de respuesta", Toast.LENGTH_SHORT).show();
        }
        }

        @Override
        public void onFailure(Call<UsuarioResponse> call, Throwable t) {
            Toast.makeText(getApplicationContext(), t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
        }
    }



  /*  //guardar los datos del login en un SharedPreferences
    private void saveLoginSharedPreferences(String celular, String contraseña){
        SharedPreferences sharedPref = getSharedPreferences("login_preferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPref.edit();
        editor.putString("celular", celular);
        editor.putString("psw", contraseña);
        editor.apply();
    }*/

    /*//Para obtener las preferencias
    * private String getFromSharedPrefernces(String key){
    * SharedPrefernces sharedPref= getActivitiy().getSharePreferences("login_preferences", Context.MODE_PRIVATE);
    * return shredPref.getString(key, "");
    * }
    *
    * */


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
