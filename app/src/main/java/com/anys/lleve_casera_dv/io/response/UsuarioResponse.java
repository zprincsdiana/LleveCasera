package com.anys.lleve_casera_dv.io.response;

import com.anys.lleve_casera_dv.model.Usuario;

import java.util.ArrayList;

public class UsuarioResponse {
    int estado;
    ArrayList<Usuario> usuario;

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public ArrayList<Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(ArrayList<Usuario> usuario) {
        this.usuario = usuario;
    }



}
