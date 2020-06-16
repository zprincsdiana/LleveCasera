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

import com.anys.lleve_casera_dv.Pojos.Productos;
import com.anys.lleve_casera_dv.R;

import java.util.ArrayList;

public class AdaptadorProductos extends RecyclerView.Adapter<AdaptadorProductos.ViewHolder>
        implements OnClickListener{
    Context context;
    LayoutInflater inflater;
    ArrayList<Productos> productos;

    //Listener - Cuando se seleccione un cardView
    private View.OnClickListener listener;

    //Constructor
    public AdaptadorProductos(Context context,ArrayList<Productos> productos){
        this.inflater = LayoutInflater.from(context);
        this.productos = productos;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Definir la vista - Enlaza el adapter con el RecyclerView ( Listar productos)
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_productos,parent,false);
        ViewHolder viewHolder= new ViewHolder(view);
        //Llamamos al evento onClick
        view.setOnClickListener(this);

        return viewHolder;
    }

    //setOnClickListener para implementar en el fragmento
    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    //Mantiene la vista
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.nombreproducto.setText(productos.get(position).getNombreProd());
        holder.precioproducto.setText(productos.get(position).getPrecioProd());
        holder.mercadoproducto.setText(productos.get(position).getNombreMerc());
        holder.distritomercado.setText(productos.get(position).getNombreDistr());
        holder.imagenView.setImageResource(productos.get(position).getImagen_prod());
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    //Evento OnClickListener
    @Override
    public void onClick(View v) {
        if (listener!=null){
            listener.onClick(v);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView imagenView;
        TextView nombreproducto,precioproducto,mercadoproducto,distritomercado;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardview_producto);
            imagenView = itemView.findViewById(R.id.imagen_producto);
            nombreproducto = itemView.findViewById(R.id.nombreProducto);
            precioproducto = itemView.findViewById(R.id.precioProducto);
            mercadoproducto = itemView.findViewById(R.id.nombreMercado);
            distritomercado = itemView.findViewById(R.id.nombreDistrito);

        }


    }
}
