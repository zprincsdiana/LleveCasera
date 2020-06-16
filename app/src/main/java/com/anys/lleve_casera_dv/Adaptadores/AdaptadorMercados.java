package com.anys.lleve_casera_dv.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.anys.lleve_casera_dv.Pojos.Mercados;
import com.anys.lleve_casera_dv.R;

import java.util.ArrayList;

public class AdaptadorMercados extends RecyclerView.Adapter<AdaptadorMercados.ViewHolder>
        implements OnClickListener {
    //Parametros
    Context context;
    LayoutInflater inflater;
    ArrayList<Mercados> mercados;

    //Listener
    private View.OnClickListener listener;

    /*Constructor*/
    public AdaptadorMercados(Context context, ArrayList<Mercados> mercados) {
        this.inflater = LayoutInflater.from(context);
        this.mercados = mercados;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Vista del CardView de los mercados + Enlace con adaptador del mercado
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_mercado,parent,false);
        ViewHolder vhMercado = new ViewHolder(vista);
        //Evento onClick para que lo muestre en ese fragment
        vista.setOnClickListener(this);
        return  vhMercado;
    }

    //Implementamos el fragmento
    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    /*Mantiene la vista*/
    @Override
    public void onBindViewHolder(@NonNull AdaptadorMercados.ViewHolder holder, int position) {
        //Obteniendo valores de la lista
        holder.nombremercado.setText(mercados.get(position).getNombreMerc());
        holder.distritomercado.setText(mercados.get(position).getNombreDistr());
        holder.provinciamercado.setText(mercados.get(position).getNombreProv());
        holder.regionMercado.setText(mercados.get(position).getNombreReg());
        holder.celularmercado.setText(mercados.get(position).getCelularMerc()+"");
        holder.imageViewMercado.setImageResource(mercados.get(position).getImagen_merc());

    }

    //Muestra los items según el tamaño del arrayList Mercados
    @Override
    public int getItemCount() {
        return mercados.size();
    }

    @Override
    public void onClick(View v) {
        if (listener!=null){
            listener.onClick(v);
        }
    }

    //Llamamos a los elementos de la clase Mercados
    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardViewMercado;
        ImageView imageViewMercado;
        TextView nombremercado,distritomercado,provinciamercado,regionMercado,celularmercado;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardViewMercado = itemView.findViewById(R.id.cardview_mercado);
            imageViewMercado = itemView.findViewById(R.id.imagen_mercado);
            nombremercado = itemView.findViewById(R.id.nombreMercado);
            distritomercado = itemView.findViewById(R.id.nombreDistrito);
            provinciamercado = itemView.findViewById(R.id.nombreProvicia);
            regionMercado = itemView.findViewById(R.id.nombreRegion);
            celularmercado = itemView.findViewById(R.id.nroCelularMercado);
        }
    }
}
