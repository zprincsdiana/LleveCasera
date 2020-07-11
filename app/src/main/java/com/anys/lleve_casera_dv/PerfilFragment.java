package com.anys.lleve_casera_dv;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class PerfilFragment extends Fragment {

    String nomUser,ApeUser, emaiuser, celular, contrasena, nomApe;
    EditText txt_nom_a,txt_ape_a,txt_cel_a,txt_psw_a,txt_email_a;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista =inflater.inflate(R.layout.fragment_perfil, container, false);

        nomUser = Preferences.obtenerPreferencesString(vista.getContext(), Preferences.PREFERENCES_nombreUsuario);
        ApeUser= Preferences.obtenerPreferencesString(vista.getContext(), Preferences.PREFERENCES_apellidoUsuario);
        emaiuser = Preferences.obtenerPreferencesString(vista.getContext(), Preferences.PREFERENCES_correoUsuario);
        celular = Preferences.obtenerPreferencesString(vista.getContext(), Preferences.PREFERENCES_celularUsuario);
        contrasena = Preferences.obtenerPreferencesString(vista.getContext(), Preferences.PREFERENCES_contrasenaUsuario);

        txt_nom_a = vista.findViewById(R.id.txt_nom_a);
        txt_ape_a = vista.findViewById(R.id.txt_ape_a);
        txt_cel_a = vista.findViewById(R.id.txt_cel_a);
        txt_psw_a = vista.findViewById(R.id.txt_psw_a);
        txt_email_a = vista.findViewById(R.id.txt_email_a);

        txt_nom_a.setText(nomUser);
        txt_ape_a.setText(ApeUser);
        txt_cel_a.setText(celular);
        txt_psw_a.setText(contrasena);
        txt_email_a.setText(emaiuser);

        // Inflate the layout for this fragment
        return vista;


    }

}