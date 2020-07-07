package com.anys.lleve_casera_dv;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.anys.lleve_casera_dv.Adaptadores.AdaptadorElementosMercado;
import com.anys.lleve_casera_dv.Bean.ElementosMercado;

import java.util.ArrayList;



public class ElementosMercadoFragment extends Fragment{
    AdaptadorElementosMercado adaptadorElementosMercado;
    RecyclerView recyclerViewElemMerc;
    ArrayList<ElementosMercado> listElemMerc;
    DialogFragment cantidadProducto = new CantProductoFragment2();
    String nomProduct="";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_elementos_mercado, container, false);

        recyclerViewElemMerc = vista.findViewById(R.id.recyclerElementosMercado);
        listElemMerc = new ArrayList<>();

        //Cargamos los elementos
        cargarListaElementosMercado();
        mostrarElemMercado();

        return vista;

    }

    private void cargarListaElementosMercado() {
        /*private int id_elementoMercado, String nombreElem, double precioElem, int imagen_elem*/
        listElemMerc.add(new ElementosMercado(1,"Arroz",2.30,R.drawable.arroz_costeno));
        listElemMerc.add(new ElementosMercado(2,"Aceite",1.80,R.drawable.arroz_costeno));
        listElemMerc.add(new ElementosMercado(3,"Avena",2.20,R.drawable.avena_ositos));
        listElemMerc.add(new ElementosMercado(4,"Quacker",2.90,R.drawable.avena_quaker));
        listElemMerc.add(new ElementosMercado(5,"Aceite",5.20,R.drawable.arroz_costeno));
        listElemMerc.add(new ElementosMercado(6,"Lentejas",1.30,R.drawable.arroz_costeno));
        listElemMerc.add(new ElementosMercado(7,"Arroz Hoja",1.30,R.drawable.arroz_hoja));
        listElemMerc.add(new ElementosMercado(8,"Arroz",2.30,R.drawable.arroz_costeno));
        listElemMerc.add(new ElementosMercado(9,"Lentejas",1.30,R.drawable.arroz_costeno));
        listElemMerc.add(new ElementosMercado(10,"Arroz",2.30,R.drawable.arroz_costeno));
        listElemMerc.add(new ElementosMercado(11,"Avena",2.30,R.drawable.avena_ositos));
        listElemMerc.add(new ElementosMercado(12,"Arroz",1.30,R.drawable.arroz_costeno));
        listElemMerc.add(new ElementosMercado(13,"Quacker",2.30,R.drawable.avena_ositos));
        listElemMerc.add(new ElementosMercado(14,"Arroz",2.30,R.drawable.arroz_costeno));
        listElemMerc.add(new ElementosMercado(15,"Arroz",2.30,R.drawable.arroz_costeno));
        listElemMerc.add(new ElementosMercado(16,"Arroz",2.30,R.drawable.arroz_costeno));
        listElemMerc.add(new ElementosMercado(17,"Arroz",2.30,R.drawable.arroz_costeno));

    }

    public void mostrarElemMercado() {
        recyclerViewElemMerc.setLayoutManager(new LinearLayoutManager(getContext()));
        adaptadorElementosMercado = new AdaptadorElementosMercado(getContext(),listElemMerc);
        recyclerViewElemMerc.setAdapter(adaptadorElementosMercado);

        adaptadorElementosMercado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Aqui se coloca
                * Navigation.findNavController(v).navigate(R.id.ID_DE_LA_VISTA_PARA_AÑADIR_PRODUCTOS_AL_CARRITO);
                * */
                nomProduct = listElemMerc.get(recyclerViewElemMerc.getChildAdapterPosition(v)).getNombreElem();

                cantidadProducto.show(getFragmentManager(), "cantidadProducto");
                Bundle bundle = new Bundle();
                bundle.putString(CantProductoFragment2.Nombre, ""+ nomProduct);
                cantidadProducto.setArguments(bundle);

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
                adaptadorElementosMercado.getFilter().filter(newText);
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);

    }

}