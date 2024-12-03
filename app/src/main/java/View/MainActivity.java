package View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.teste04.R;

import java.util.List;

import controller.CursoController;
import controller.PessoaController;
import model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;
    PessoaController controller;
    CursoController cursoController;
    List<String> nomesCursos;
    EditText PrimeiroNome, SobreNome, CursoDesejado, TelefoneContato;
    Button LIMPAR, SALVAR, FINALIZAR;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cursoController = new CursoController();

        pessoa = new Pessoa();
        controller = new PessoaController(MainActivity.this);
        controller.toString();
        controller.buscar(pessoa);
        nomesCursos = cursoController.dadosSpinner();


        PrimeiroNome = findViewById(R.id.editPrimeiroNome);
        SobreNome = findViewById(R.id.editSobreNome);
        CursoDesejado = findViewById(R.id.editCursoDesejado);
        TelefoneContato = findViewById(R.id.TelefoneContato);

        spinner = findViewById(R.id.spinner);

        PrimeiroNome.setText(pessoa.getPrimeiroNome());
        SobreNome.setText(pessoa.getSobrenome());
        CursoDesejado.setText(pessoa.getCursoDesejado());
        TelefoneContato.setText(pessoa.getTelefoneContato());

        LIMPAR = findViewById(R.id.LIMPAR);

        SALVAR = findViewById(R.id.SALVAR);

        FINALIZAR = findViewById(R.id.FINALIZAR);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,cursoController.dadosSpinner());
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner.setAdapter(adapter);


    FINALIZAR.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick ( View view){
            Toast.makeText(MainActivity.this,"Volte Sempre", Toast.LENGTH_LONG).show();
            finish();
        }
    });
    SALVAR.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View view){
            pessoa.setPrimeiroNome(PrimeiroNome.getText().toString());
            pessoa.setSobrenome(SobreNome.getText().toString());
            pessoa.setCursoDesejado(CursoDesejado.getText().toString());
            pessoa.setTelefoneContato(TelefoneContato.getText().toString());

            Toast.makeText(MainActivity.this,"Dados Salvos" + pessoa.toString(),Toast.LENGTH_LONG).show();

            controller.SALVAR(pessoa);

       }
        });
    LIMPAR.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            PrimeiroNome.setText("");
            SobreNome.setText("");
            CursoDesejado.setText("");
            TelefoneContato.setText("");

            controller.limpar();

        }
    });

        Log.i("PooAndroid",pessoa.toString());

    }

}