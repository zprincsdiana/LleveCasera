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

import com.anys.lleve_casera_dv.Adaptadores.AdaptadorProductos;
import com.anys.lleve_casera_dv.Bean.Productos;

import java.util.ArrayList;


public class ProductosFragment extends Fragment {
    AdaptadorProductos adaptadorProductos;
    RecyclerView recyclerViewProductos;
    ArrayList<Productos> listProductos;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_productos, container, false);
        recyclerViewProductos = view.findViewById(R.id.recyclerview_producto);
        listProductos = new ArrayList<>();
        //Cargar la List
        cargarListaProductos();
        mostrarElementos();

        return view;
    }

    public void cargarListaProductos(){
        listProductos.add(new Productos(1,"Quacker","Precio: S/1.50","Mercado Unicachi",
                "Distrito: La Victoria",R.drawable.avena_quaker));
        listProductos.add(new Productos(2,"Arroz","Precio: S/2.50","Mercado Caqueta",
                "Distrito: San Martin de Porres",R.drawable.arroz_costeno));
        listProductos.add(new Productos(3,"Avena","Precio:S/1.50","Mercado Caqueta",
                "Distrito: San Martin de Porres",R.drawable.avena_ositos));
        listProductos.add(new Productos(4,"Ajinomen","Precio:S/2.50","Mercado Caqueta",
                "Distrito: San Martin de Porres",R.drawable.ajinomen));
        listProductos.add(new Productos(5,"Frejoles","Precio:S/2.50","Mercado Caqueta",
                "Distrito: San Martin de Porres",R.drawable.frejol_costeno));
        listProductos.add(new Productos(6,"Chorizo","Precio:S/2.50","Mercado Caqueta",
                "Distrito: San Martin de Porres",R.drawable.chorizo_ottok));
        listProductos.add(new Productos(7,"Azucar","Precio:S/2.50","Mercado Caqueta",
                "Distrito: San Martin de Porres",R.drawable.azucar_rubia));
        listProductos.add(new Productos(8,"Arroz Hoja","Precio:S/2.50","Mercado Caqueta",
                "Distrito: San Martin de Porres",R.drawable.arroz_hoja));
    }

    public void mostrarElementos(){
        recyclerViewProductos.setLayoutManager(new LinearLayoutManager(getContext()));
        adaptadorProductos = new AdaptadorProductos(getContext(),listProductos);
        recyclerViewProductos.setAdapter(adaptadorProductos);

        adaptadorProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Prueba
                String mostrarNomProd = listProductos.get(recyclerViewProductos.getChildAdapterPosition(v)).getNombreProd();
                Toast.makeText(getContext(),""+mostrarNomProd,Toast.LENGTH_SHORT).show();*/
                Navigation.findNavController(v).navigate(R.id.productoMercadoFragment);
            }
        });

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
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
                adaptadorProductos.getFilter().filter(newText);
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);

    }
}