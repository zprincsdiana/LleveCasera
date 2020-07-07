package com.anys.lleve_casera_dv.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.anys.lleve_casera_dv.Bean.ElementosMercado;
import com.anys.lleve_casera_dv.Bean.Productos;
import com.anys.lleve_casera_dv.R;

import java.util.ArrayList;
import java.util.Collection;

public class AdaptadorElementosMercado extends RecyclerView.Adapter<AdaptadorElementosMercado.ViewHolder>
    implements View.OnClickListener, Filterable {
    Context context;
    LayoutInflater inflater;
    ArrayList<ElementosMercado> elementosMercados,listaTotElemMerc;

    private View.OnClickListener listener;

    public AdaptadorElementosMercado(Context context, ArrayList<ElementosMercado> elementosMercados) {
        this.inflater = LayoutInflater.from(context);
        this.elementosMercados = elementosMercados;
        this.listaTotElemMerc = new ArrayList<>(elementosMercados);

    }


    @Override
    public void onClick(View v) {
        if (listener!=null){
            listener.onClick(v);
        }

    }

    @NonNull
    @Override
    public AdaptadorElementosMercado.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_elementos_mercado,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        view.setOnClickListener(this);

        return viewHolder;
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return elementosMercados.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {

        //Ejecuta en el background
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            ArrayList<ElementosMercado> listaFiltrada = new ArrayList<>();

            if (charSequence.toString().isEmpty()){
                listaFiltrada.addAll(listaTotElemMerc);
            }else {
                for (ElementosMercado todo_elem_mercado : listaTotElemMerc){
                    String nombres_productos = todo_elem_mercado.getNombreElem().toLowerCase();

                    if (nombres_productos.contains(charSequence.toString().toLowerCase())){
                        listaFiltrada.add(todo_elem_mercado);
                    }
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = listaFiltrada;
            return filterResults;
        }

        //Ejecuta en la UI
        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            elementosMercados.clear();
            elementosMercados.addAll((Collection<? extends ElementosMercado>) filterResults.values);
            notifyDataSetChanged();
        }
    };

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardViewElemMercado;
        ImageView imageViewElemMerc;
        TextView nombreElemMerc,precioElemMerc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            cardViewElemMercado = itemView.findViewById(R.id.cardview_elementos_mercado);
            imageViewElemMerc = itemView.findViewById(R.id.imagen_elemento_mercado);
            nombreElemMerc = itemView.findViewById(R.id.nombreElementoMercado);
            precioElemMerc = itemView.findViewById(R.id.precioElementoMercado);

        }
    }


    @Override
    public void onBindViewHolder(@NonNull AdaptadorElementosMercado.ViewHolder holder, int position) {
        holder.nombreElemMerc.setText(elementosMercados.get(position).getNombreElem());
        holder.precioElemMerc.setText(elementosMercados.get(position).getPrecioElem()+"");
        holder.imageViewElemMerc.setImageResource(elementosMercados.get(position).getImagen_elem());

    }
}
