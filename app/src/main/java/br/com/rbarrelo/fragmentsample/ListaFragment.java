package br.com.rbarrelo.fragmentsample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListaFragment extends Fragment implements AdapterView.OnItemClickListener {

    ArrayAdapter<String> adapter;

    public ListaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.lista, container, false);

        String[] itens = { "1 Velloso",
                           "2 Arce",
                           "3 Júnior Baiano",
                           "4 Cléber",
                           "5 Roque Júnior",
                           "6 Júnior",
                           "7 Paulo Nunes",
                           "8 César Sampaio",
                           "9 Oséas",
                           "10 Alex",
                           "11 Zinho",
                           "12 Marcos",
                           "13 Neném",
                           "14 Rivarola",
                           "15 Tiago Silva",
                           "16 Rogério",
                           "17 Evair",
                           "18 Jackson",
                           "19 Pedro",
                           "20 Juliano",
                           "21 Rubens Júnior",
                           "22 Sérgio",
                           "23 Agnaldo",
                           "24 Euller",
                           "25 Galeano",
                           "26 Edmílson"};

        ListView lista = (ListView) view.findViewById(R.id.lvLista);
        adapter = new ArrayAdapter<String>(getActivity(),
                                                                android.R.layout.simple_list_item_1,
                                                                itens);

        lista.setAdapter(adapter);
        lista.setOnItemClickListener(this);
        return view;
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        String item = (String) adapterView.getItemAtPosition(position);
        selecionaJogador(item);
    }

    public void selecionaJogador(String jogador) {
        Toast.makeText(getActivity(), jogador, Toast.LENGTH_SHORT).show();

        Bundle argumentos = new Bundle();
        argumentos.putString("jogador", jogador);

        DetalheFragment detalhe = new DetalheFragment();
        detalhe.setArguments(argumentos);

        FragmentTransaction transaction =
                getActivity().getSupportFragmentManager().beginTransaction();

        if(MainActivity.isLand(getActivity())){
            transaction.replace(R.id.direita, detalhe, DetalheFragment.class.getCanonicalName());
        }else {
            transaction.replace(R.id.unico, detalhe, DetalheFragment.class.getCanonicalName());
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }


}
