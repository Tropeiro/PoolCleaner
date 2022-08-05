package com.example.poolcleaner.fragmentos;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.poolcleaner.R;
import com.example.poolcleaner.TelaPrincipal;
import com.example.poolcleaner.adapter.AjudaAdapter;
import com.example.poolcleaner.helper.RecyclerItemClickListener;
import com.example.poolcleaner.model.Ajuda;

import java.util.ArrayList;
import java.util.List;

public class TutorialFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<Ajuda> ajudas = new ArrayList<Ajuda>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tutorial, container, false);

        this.CarregaAjuda();
        AjudaAdapter adaptador = new AjudaAdapter(ajudas);

        recyclerView = view.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        recyclerView.setAdapter(adaptador);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putInt("position",position);
                FragmentDica fragmentDica = new FragmentDica();
                fragmentDica.setArguments(bundle);
                ((TelaPrincipal)getActivity()).replaceFragment(fragmentDica);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        }));

        return view;
    }

    public void CarregaAjuda(){
        Ajuda ajuda = new Ajuda("Equipamento recomendado");
        this.ajudas.add(ajuda);

        ajuda = new Ajuda("Antes de adicionar os produtos a piscina");
        this.ajudas.add(ajuda);

        ajuda = new Ajuda("Como manusear os produtos químicos");
        this.ajudas.add(ajuda);

        ajuda = new Ajuda("Coloração da água");
        this.ajudas.add(ajuda);

        ajuda = new Ajuda("Tempo recomendado de ação do produto");
        this.ajudas.add(ajuda);

        ajuda = new Ajuda("Manutenção");
        this.ajudas.add(ajuda);

        ajuda = new Ajuda("Em caso de emergências");
        this.ajudas.add(ajuda);


    }
}