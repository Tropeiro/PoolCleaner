package com.example.poolcleaner.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.poolcleaner.R;
import com.example.poolcleaner.model.Ajuda;

import java.util.List;

public class AjudaAdapter extends RecyclerView.Adapter<AjudaAdapter.MyViewHolder> {

    private List<Ajuda> listaAjudas;

    public AjudaAdapter(List<Ajuda> ajudas){
        this.listaAjudas = ajudas;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemAjuda = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_main, parent, false);

        return new MyViewHolder(itemAjuda);
    }

    @Override
    public void onBindViewHolder(@NonNull AjudaAdapter.MyViewHolder holder, int position) {
        Ajuda ajuda = listaAjudas.get(position);
        holder.dica.setText(ajuda.getTitulo());
    }

    @Override
    public int getItemCount() {
        return listaAjudas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView dica;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            dica = itemView.findViewById(R.id.txtAjuda);
        }
    }
}
