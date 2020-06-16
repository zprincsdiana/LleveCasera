package com.anys.lleve_casera_dv;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.anys.lleve_casera_dv.Adaptadores.AdaptadorMercados;
import com.anys.lleve_casera_dv.Bean.Mercados;

import java.util.ArrayList;


public class MercadoFragment extends Fragment {
    AdaptadorMercados adaptadorMercados;
    RecyclerView recyclerViewMercados;
    ArrayList<Mercados> listMercados;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewVista = inflater.inflate(R.layout.fragment_mercado, container, false);
        recyclerViewMercados = viewVista.findViewById(R.id.recyclerMercado);
        listMercados = new ArrayList<>();

        //Cargar Lista
        cargarListaMercados();
        mostrarElem();

        return viewVista;
    }

    public void cargarListaMercados(){
        listMercados.add(new Mercados(1,R.drawable.ic_mercado,999887745,
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
                "Mercado Pesqueros","Callao","Callao","Lima "));

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


}