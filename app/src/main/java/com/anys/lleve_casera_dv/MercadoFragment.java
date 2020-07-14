package com.anys.lleve_casera_dv;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.anys.lleve_casera_dv.Adaptadores.AdaptadorMercados;
import com.anys.lleve_casera_dv.Bean.Mercados;
import com.anys.lleve_casera_dv.io.mercadoApiAdapter;
import com.anys.lleve_casera_dv.io.response.MercadosResponse;
import com.anys.lleve_casera_dv.model.Mercado;
import com.anys.lleve_casera_dv.model.Usuario;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MercadoFragment extends Fragment {
    AdaptadorMercados adaptadorMercados;
    RecyclerView recyclerViewMercados;
    ArrayList<Mercado> listMercados;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewVista = inflater.inflate(R.layout.fragment_mercado, container, false);
        recyclerViewMercados = viewVista.findViewById(R.id.recyclerMercado);
        //listMercados = new ArrayList<>();

        //Cargar Lista
        cargarListaMercados();
        //mostrarElem();

        return viewVista;
    }

    public void cargarListaMercados(){

        Call<MercadosResponse> call = mercadoApiAdapter.getApiService().getAllMercado();
        call.enqueue(new mercadosCallback());
/*        listMercados.add(new Mercados(1,R.drawable.ic_mercado,999887745,
                "Unicachi","Villa El Salvador","Lima","Lima "));
        listMercados.add(new Mercados(2,R.drawable.mercado2,999887745,
                "El Hueco","La Victoria","Lima","Lima "));
        listMercados.add(new Mercados(3,R.drawable.ic_mercado,999887745,
                "La Parada","La Victoria","Lima","Lima "));
        listMercados.add(new Mercados(4,R.drawable.mercado4,999887745,
                "Abancay","La Victoria","Lima","Lima "));
        listMercados.add(new Mercados(5,R.drawable.mercado3,999887745,
                "Caquetá","San Martin de Porres","Lima","Lima "));
        listMercados.add(new Mercados(6,R.drawable.mercado2,999887745,
                "Ciudad de Dios","San Juan de Miraflores","Lima","Lima "));
        listMercados.add(new Mercados(7,R.drawable.mercado3,999887745,
                "Mercado Pesqueros","Callao","Callao","Lima "));*/

    }
    class mercadosCallback implements Callback<MercadosResponse>{

        @Override
        public void onResponse(Call<MercadosResponse> call, Response<MercadosResponse> response) {
            if(response.isSuccessful()){
                MercadosResponse mercadosResponse= response.body();
                if(mercadosResponse.getEstado() == 1){
                    listMercados = mercadosResponse.getMercados();
                    mostrarElem();
                    //poblarRecyclerView(mercadosResponse.getMercados());
                }
            }else{
                Toast.makeText(getContext(), "Error en el formato de respuesta", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onFailure(Call<MercadosResponse> call, Throwable t) {



        }
    }

    private  List<String>  poblarRecyclerView(ArrayList<Mercado> mercados) {
        List<String> list = new ArrayList<>();

        for (Mercado m : mercados) {
            list.add( m.getCodigoMercado());
            list.add( m.getNombreMercado());
            list.add( m.getDistritoMercado());
            list.add( m.getProvinciaMercado());
            list.add( m.getRegionMercado());
            list.add( m.getCelularMercado());
        }
        return list;
    }

    public void mostrarElem(){
        recyclerViewMercados.setLayoutManager(new LinearLayoutManager(getContext()));
        adaptadorMercados = new AdaptadorMercados(getContext(),listMercados);
        recyclerViewMercados.setAdapter(adaptadorMercados);
        adaptadorMercados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /* String mostrarNomMercado = listMercados.get(recyclerViewMercados.getChildAdapterPosition(v)).getNombreMerc();
                Toast.makeText(getContext(),""+mostrarNomMercado,Toast.LENGTH_SHORT).show();*/

                Navigation.findNavController(v).navigate(R.id.elementos_mercadoFragment);
            }
        });

    }

    @Override
    public void onCreateOptionsMenu(Menu menu,MenuInflater inflater) {
        inflater.inflate(R.menu.principal, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adaptadorMercados.getFilter().filter(newText);
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }
}