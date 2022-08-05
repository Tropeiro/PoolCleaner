package com.example.poolcleaner.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.poolcleaner.R;

public class FragmentDica extends Fragment {

    private TextView txtTituloDica, txtTextoDica;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dica1, container, false);

        txtTituloDica = view.findViewById(R.id.txtTituloDica);
        txtTextoDica = view.findViewById(R.id.txtTextoDica);

        Bundle bundle = getArguments();
        if(bundle != null){
            int id = getArguments().getInt("position", 0);
            Toast.makeText(getContext(), "id =" + id, Toast.LENGTH_SHORT).show();
            switch(id){
                case 0:
                    txtTituloDica.setText("Equipamento recomendado:");
                    String saida = "O equipamento recomendado para uso durante o manuseio destes produtos é:" +
                            "\n- Um par de luvas de borracha;\n- Usar camisa de manga comprida e calças longas;\n- Máscara;" +
                            "\n- Proteção ocular;\n\nFerramentas para limpeza:\n- Haste Telescópica;\n- Rede e Escova compatíveis com a haste;" +
                            "\n- Balde de +/- 20 litros;\n- Copo medidor;\n- Colher de cabo longo;\n- Esponja;\n- Uma mangueira ligada a uma fonte de água, se necessário;";
                    txtTextoDica.setText(saida);
                    break;
                case 1:
                    txtTituloDica.setText("Antes de adicionar os produtos a piscina");
                    saida = "Antes de começar a manusear os produtos químicos, esfregue as paredes e o chão da piscina com a escova acoplada na haste.\n" +
                            "Remova quaisquer detritos que estejam no solo e na superfície da água. Limpe as bordas da piscina com uma esponja, com um produto de limpeza próprio para isto ou a própria barrilha.";
                    txtTextoDica.setText(saida);
                    break;
                case 2:
                    txtTituloDica.setText("Como manusear os produtos químicos");
                    saida = "Depois de realizar o cálculo das substâncias na tela 'Cálculo' e também após esfregar a piscina e remover os detritos, siga os passos a seguir:\n" +
                            "Passo 1: Encha o balde com água da própria piscina.\n" +
                            "Passo 2: Adicione sulfato de alumínio checando a medida certa obtida anteriormente e misture. Assim que a água parar de circular, espalhe a mistura pela superfície da piscina.\n" +
                            "Passo 3: Repita o procedimento, agora com a Barrilha.\n" +
                            "Passo 4: Repita o procedimento, agora com o Cloro, mexa a mistura pelo menos mais três vezes para ter certeza de que o cloro está bem dissolvido na água, e então adicione à piscina.\n" +
                            "Passo 5: Mexa a água da piscina para estimular a mistura dos químicos e aguarde de 24 a 48 horas.\n" +
                            "Passo 6: Drene a piscina para remover a poeira decantada no fundo da piscina.\n" +
                            "Passo 7: Limpe o que sobrar da sujeira e reencha a piscina.\n" +
                            "Sua piscina deve ser limpa duas vezes por semana.";
                    txtTextoDica.setText(saida);
                    break;
                case 3:
                    txtTituloDica.setText("Coloração da água");
                    saida = "Caso após o tratamento realizado a água estiver verde, você precisará de um 'algicida de choque', siga as instruções da embalagem para o uso.\n" +
                            "Se a água estiver com aparência 'turva' (difícil de enxergar o fundo da piscina), pode ser que seja necessário a realização de uma nova limpeza, aguarde aproximadamente três dias para uma nova limpeza.";

            }
        }

        // Inflate the layout for this fragment
        return view;
    }
}