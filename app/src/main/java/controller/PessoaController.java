package controller;

import android.util.Log;
import android.view.View;

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

}
