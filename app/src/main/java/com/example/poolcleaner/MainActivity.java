package com.example.poolcleaner;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIniciar = findViewById(R.id.btnIniciar);

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder atencao = new AlertDialog.Builder(MainActivity.this);
                atencao.setTitle("Atenção!");
                atencao.setMessage("O uso de produtos químicos pode ser prejudicial à saúde, principalmente quando em contato com a pele." +
                        "\n\nÉ recomendável o uso de equipamentos adequados antes do manuseio destes produtos (luvas, óculos e máscara).\n" +
                        "\nNão entre na piscina enquanto os produtos estiverem agindo.");
                atencao.setIcon(R.drawable.warning);
                atencao.setNeutralButton("Entendido", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(MainActivity.this, TelaPrincipal.class);
                        startActivity(intent);
                    }
                });
                atencao.show();
            }
        });
    }
}