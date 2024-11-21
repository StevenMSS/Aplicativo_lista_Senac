package controller;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import model.Pessoa;

public class PessoaController {


    @Override
    public String toString() {
        Log.d("mvc-controller", "CONTROLLER INICIADA");
        return "PessoaController{}";
    }
    public void  SALVAR(Pessoa pessoa){
        Log.d("mvc-controller", "DADOS SALVOS: "  + pessoa.toString());
    }
    //public void FINALIZAR(Pessoa pessoa) {
        //Log.d("mvc-controller", "Volte Sempre: " + pessoa.toString());
    //}
   // public void LIMPAR(Pessoa pessoa){
        //Log.d("mvc-controller","Dados Limpos: "+ pessoa.toString());
    //}

}
