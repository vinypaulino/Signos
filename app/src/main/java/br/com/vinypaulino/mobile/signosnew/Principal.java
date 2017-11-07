package br.com.vinypaulino.mobile.signosnew;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Principal extends AppCompatActivity {
//declarando as variaveis do tipo Spinner
    private Spinner spinnerDia = null;
    private Spinner spinnerMes = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        /////////////////////////////////PREENCHENDO OS SPINNERS///////////////////////////////////////////////////////////////

        // atribuindo os Objetos do tipo Spinner nas variaveis criadas na camada visual
        spinnerDia = (Spinner) findViewById(R.id.spinnerDia);
        spinnerMes = (Spinner) findViewById(R.id.spinnerMes);

        //adicionando o adapter que serve pra pegar os dados de um array ou banco de dados
        // pega os dados do String.xml e joga no spinner
        ArrayAdapter<CharSequence> adapter_dia = ArrayAdapter.createFromResource(this, R.array.dias,
                android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter_mes = ArrayAdapter.createFromResource(this, R.array.meses,
                android.R.layout.simple_spinner_item);
        //especificar o tipo de dropdown a usar
        adapter_dia.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_mes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // setar o adapter criado em cima
        spinnerDia.setAdapter(adapter_dia);
        spinnerMes.setAdapter(adapter_mes);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    }
}
