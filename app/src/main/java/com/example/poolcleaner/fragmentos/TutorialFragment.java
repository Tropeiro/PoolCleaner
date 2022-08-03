package com.example.poolcleaner.fragmentos;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.poolcleaner.R;
import com.example.poolcleaner.adapter.AjudaAdapter;
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

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(AjudaAdapter);

        return view;
    }

    public void CarregaAjuda(){
        Ajuda ajuda = new Ajuda("Dica 1");
        this.ajudas.add(ajuda);
    }
}