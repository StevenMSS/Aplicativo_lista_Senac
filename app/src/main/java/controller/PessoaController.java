package controller;

import android.content.SharedPreferences;
import android.util.Log;

import View.MainActivity;
import model.Pessoa;

public class PessoaController {

    SharedPreferences preferences;
    public static final String NOME_PREFERENCES = "pref_listvip";
    SharedPreferences.Editor listavip;

    public PessoaController(MainActivity mainActivity){
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listavip = preferences.edit();
    }

    @Override
    public String toString() {
        Log.d("mvc-controller", "CONTROLLER INICIADA");
        return super.toString();
    }
    public void  SALVAR(Pessoa pessoa){
        Log.d("mvc-controller", "DADOS SALVOS: "  + pessoa.toString());

        listavip.putString("PrimeiroNome", pessoa.getPrimeiroNome());
        listavip.putString("Sobrenome", pessoa.getSobrenome());
        listavip.putString("CursoDesejado", pessoa.getCursoDesejado());
        listavip.putString("TelefoneDesejado", pessoa.getTelefoneContato());

        listavip.apply();

    }
    public void limpar(){
        listavip.clear();
        listavip.apply();
    }
    public Pessoa buscar(Pessoa pessoa){
        pessoa.setPrimeiroNome(preferences.getString("PrimeiroNome",""));
        pessoa.setSobrenome(preferences.getString("Sobrenome",""));
        pessoa.setCursoDesejado(preferences.getString("CursoDesejado",""));
        pessoa.setTelefoneContato(preferences.getString("TelefoneContato",""));
        return pessoa;
    }

}
