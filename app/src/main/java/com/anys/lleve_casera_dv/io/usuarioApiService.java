package com.anys.lleve_casera_dv.io;

import com.anys.lleve_casera_dv.io.response.UsuarioResponse;
import com.anys.lleve_casera_dv.model.Usuario;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface usuarioApiService {


    @POST("Validar_Usuario.php")
    Call<UsuarioResponse> userLogin(@Body Usuario usuario);
     /*       @Field("celularUsuario") String celularUsuario,
            @Field("contrasenaUsuario") String contrasenaUsuario
    );*/

}
