package br.com.rbarrelo.fragmentsample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by rafaelbarrelo on 7/13/14.
 */
public class DetalheFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detalhe, container, false);

        String jogador = "Selecione um campeão da Libertadores de 1999";
        if  (getArguments() != null) {
            jogador = getArguments().getString("jogador");
        }

        TextView texto = (TextView) view.findViewById(R.id.detalheText);
        texto.setText(jogador);

        return view;
    }
}
