package com.anys.lleve_casera_dv;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.anys.lleve_casera_dv.Adaptadores.AdaptadorMercados;
import com.anys.lleve_casera_dv.Pojos.Mercados;

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
        listMercados.add(new Mercados(1,R.drawable.ubereats_logo,999887745,
                "Unicachi","La Victoria","Lima","Lima "));
        listMercados.add(new Mercados(1,R.drawable.ubereats_logo,999887745,
                "Unicachi","La Victoria","Lima","Lima "));
        listMercados.add(new Mercados(1,R.drawable.ubereats_logo,999887745,
                "Unicachi","La Victoria","Lima","Lima "));
        listMercados.add(new Mercados(1,R.drawable.ubereats_logo,999887745,
                "Unicachi","La Victoria","Lima","Lima "));
        listMercados.add(new Mercados(1,R.drawable.ubereats_logo,999887745,
                "Unicachi","La Victoria","Lima","Lima "));
        listMercados.add(new Mercados(1,R.drawable.ubereats_logo,999887745,
                "Unicachi","La Victoria","Lima","Lima "));

    }

    public void mostrarElem(){
        recyclerViewMercados.setLayoutManager(new LinearLayoutManager(getContext()));
        adaptadorMercados = new AdaptadorMercados(getContext(),listMercados);
        recyclerViewMercados.setAdapter(adaptadorMercados);
        adaptadorMercados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mostrarNomMercado = listMercados.get(recyclerViewMercados.getChildAdapterPosition(v)).getNombreMerc();
                Toast.makeText(getContext(),""+mostrarNomMercado,Toast.LENGTH_SHORT).show();
            }
        });

    }


}