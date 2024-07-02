package com.example.frequenciamaxima;
import static android.view.LayoutInflater.*;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class adaptador<context> extends BaseAdapter{
    LayoutInflater inflater;
    List<pessoa> pessoas;
    public adaptador(List<pessoa> pessoas, context ctx){
        this.pessoas = pessoas;
        inflater = from((Context) ctx);

    }
    @Override
    public int getCount() {
        return pessoas.size();
    }
    public Object getItem(int position){
        return pessoa.get(position);
    }
    public long getItemId(int position){
        return position;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        View v = inflater.inflate(R.layout.pessos_item, null);
        TextView txtNome = v.findViewById(R.id.txtNomeItem);

        TextView txtFcm = v.findViewById(R.id.txtFcm);
        pessoa p = pessoas.get(position);
        txtNome.setText(p.getNome());

        txtFcm.setText("\n FMC: " + p.getFcm());
        return v;
    }
}