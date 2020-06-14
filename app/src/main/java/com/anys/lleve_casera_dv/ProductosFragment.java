package com.anys.lleve_casera_dv;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.anys.lleve_casera_dv.Adaptadores.AdaptadorProductos;
import com.anys.lleve_casera_dv.Pojos.Productos;

import java.util.ArrayList;


public class ProductosFragment extends Fragment {
    AdaptadorProductos adaptadorProductos;
    RecyclerView recyclerViewProductos;
    ArrayList<Productos> listProductos;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_productos, container, false);
        recyclerViewProductos = view.findViewById(R.id.recyclerview);
        listProductos = new ArrayList<>();
        //Cargar la List
        cargarLista();

        mostrarElementos();

        return view;
    }

    public void cargarLista(){
        listProductos.add(new Productos(1,"Quacker","Precio: S/1.50","Mercado Unicachi",
                "Distrito: La Victoria",R.drawable.logo));
        listProductos.add(new Productos(2,"Arroz","Precio: S/2.50","Mercado Caqueta",
                "Distrito: San Martin de Porres",R.drawable.wallpaper));
        listProductos.add(new Productos(3,"Arroz","Precio:S/2.50","Mercado Caqueta",
                "Distrito: San Martin de Porres",R.drawable.wallpaper));
        listProductos.add(new Productos(4,"Arroz","Precio:S/2.50","Mercado Caqueta",
                "Distrito: San Martin de Porres",R.drawable.wallpaper));
        listProductos.add(new Productos(5,"Arroz","Precio:S/2.50","Mercado Caqueta",
                "Distrito: San Martin de Porres",R.drawable.logo));
        listProductos.add(new Productos(6,"Arroz","Precio:S/2.50","Mercado Caqueta",
                "Distrito: San Martin de Porres",R.drawable.wallpaper));
        listProductos.add(new Productos(7,"Arroz","Precio:S/2.50","Mercado Caqueta",
                "Distrito: San Martin de Porres",R.drawable.wallpaper));
        listProductos.add(new Productos(8,"Arroz","Precio:S/2.50","Mercado Caqueta",
                "Distrito: San Martin de Porres",R.drawable.logo));
    }

    public void mostrarElementos(){
        recyclerViewProductos.setLayoutManager(new LinearLayoutManager(getContext()));
        adaptadorProductos = new AdaptadorProductos(getContext(),listProductos);
        recyclerViewProductos.setAdapter(adaptadorProductos);

        adaptadorProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mostrarNomProd = listProductos.get(recyclerViewProductos.getChildAdapterPosition(v)).getNombreProd();
                Toast.makeText(getContext(),""+mostrarNomProd,Toast.LENGTH_LONG).show();
            }
        });

    }

}