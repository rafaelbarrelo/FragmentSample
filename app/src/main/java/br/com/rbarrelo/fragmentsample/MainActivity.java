package br.com.rbarrelo.fragmentsample;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        if (MainActivity.isLand(this)){
            transaction.replace(R.id.esquerda, new ListaFragment());
            transaction.replace(R.id.direita, new DetalheFragment());
        }else{
            transaction.replace(R.id.unico, new ListaFragment());
        }

        transaction.commit();
    }

    public static boolean isLand(Context context) {
        return context.getResources().getBoolean(R.bool.isLand);
    }

}
