package com.example.poolcleaner.fragmentos;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.poolcleaner.R;

public class CalculoFragment extends Fragment {

    private EditText edtLitragem;
    private TextView txtInstrucoes;
    private Button btnCalcula;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calculo, container, false);

        edtLitragem = view.findViewById(R.id.edtLitragem);
        txtInstrucoes = view.findViewById(R.id.txtInstrucoes);
        btnCalcula = view.findViewById(R.id.btnCalcula);

        btnCalcula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtLitragem.onEditorAction(EditorInfo.IME_ACTION_DONE);
                if(edtLitragem.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "Preencha o campo com a litragem da piscina.", Toast.LENGTH_SHORT).show();
                }else{
                    double litros = Double.parseDouble(edtLitragem.getText().toString());
                    double qntSulfato = (litros / 1000) * 40;
                    double qntBarrilha = (litros / 1000) * 30;
                    double qntCloro = (litros / 1000) * 4;

                    String saida = String.format("Para uma piscina com capacidade para %.0f litros:\n\n" +
                            "Adicione:\n" + "- %.1f gramas de Sulfato de alumínio (%.1f gramas para manutenção);\n- %.1f gramas de Barrilha (%.1f gramas para manutenção);\n- %.1f gramas de Cloro (%.1f gramas para manutenção);", litros, qntSulfato, qntSulfato/2, qntBarrilha, qntBarrilha/2, qntCloro, qntCloro/2);
                    txtInstrucoes.setText(saida);
                    edtLitragem.setText("");
                }
            }
        });

        return view;
    }


}