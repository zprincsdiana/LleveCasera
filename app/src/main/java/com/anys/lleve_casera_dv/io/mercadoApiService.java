package com.anys.lleve_casera_dv.io;

import com.anys.lleve_casera_dv.io.response.MercadosResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface mercadoApiService {

    @GET ("Obtener_mercado.php")
    Call<MercadosResponse> getAllMercado();

}
