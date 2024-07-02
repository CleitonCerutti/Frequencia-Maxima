package com.example.frequenciamaxima;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText txtNome;
    EditText txtIdade;

    Button adicionarEcalcular;
    ListView listPessoas;
    List<pessoa> pessoas = new ArrayList<>();
    adaptador adapter;


    View.OnClickListener btClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            adicionarEcalcular(v);
        }


    };

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNome = findViewById(R.id.txtNome);
        txtIdade = findViewById(R.id.txtIdade);
        View txtFcm = findViewById(R.id.txtFcm);
        adicionarEcalcular = findViewById(R.id.adicionarEcalcular);
        adicionarEcalcular.setOnClickListener(btClickListener);
        listPessoas = findViewById(R.id.lista);
        pessoas = new ArrayList<>();
        adapter = new adaptador<>(pessoas, getBaseContext());
        listPessoas.setAdapter(adapter);
    }

    public void adicionarEcalcular(View v) {
        pessoa p = new pessoa();
        p.setNome(txtNome.getText().toString());
        p.setIdade(txtIdade.getText().toString());

        Toast.makeText(getBaseContext(), p.toString(), Toast.LENGTH_LONG).show();
               try {
            int idade = Integer.parseInt(p.getIdade());
            int frequenciaCardiacaMaxima = 220 - idade;
            p.setFcm(String.valueOf(frequenciaCardiacaMaxima));
            pessoas.add(p);
            adapter.notifyDataSetChanged();


            Collections.sort(pessoas, new Comparator<pessoa>() {
                @Override
                public int compare(pessoa pessoa1, pessoa pessoa2) {
                    return Integer.compare(Integer.parseInt(pessoa2.getFcm()), Integer.parseInt(pessoa1.getFcm()));
                }
            });
        } finally {

        }
        ;
    }
}