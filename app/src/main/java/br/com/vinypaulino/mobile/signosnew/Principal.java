package br.com.vinypaulino.mobile.signosnew;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Principal extends AppCompatActivity {
    //declarando as variaveis do tipo Spinner
    private Spinner spinnerDia = null;
    private Spinner spinnerMes = null;

    private void validarData() {
        //obtemos o índice selecionado nos spinners;
        int dia = spinnerDia.getSelectedItemPosition();
        int mes = spinnerMes.getSelectedItemPosition();
        //como os índices dos spinners começam a contar em 0, enquanto os dias e meses começam em 1, precisamos incrementar o valor obtido para que os índices sejam equivalentes;
        dia++;
        mes++;
        //caso o usuário selecione um dia inválido para o mês selecionado, definimos o dia como sendo o último dia válido do mês. Por exemplo, caso o usuário selecione 30 de fevereiro, o spinner será configurado para 29 de fevereiro automaticamente.
        if (dia > 29 && mes == 2) {
            spinnerDia.setSelection(28);
        } else if ((mes == 4 || mes == 60 || mes == 11) && (dia > 30)) {
            spinnerDia.setSelection(29);
        }

    }


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

        spinnerDia.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
                 // no evento onItemSelected o método validarData será chamado;
                    @Override
                    public void onItemSelected(AdapterView<?> parent,
                                               View view,
                                               int position,
                                               long id) {
                        validarData();
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
                    }
                }
        );

        spinnerMes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                validarData();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // referencia do botão enviar no código Java
        Button enviar = (Button) findViewById(R.id.buttonEnviar);
        // disparar a ação do botão
        enviar.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                int posicaoDia = spinnerDia.getSelectedItemPosition();
                int posicaoMes = spinnerMes.getSelectedItemPosition();
                posicaoDia++;
                posicaoMes++;

                // Instanca da Classe Interpretador de Signos
                InterpretadorSigno Interpretador = new InterpretadorSigno();

                //Cria uma variavel do objeto Signo
                Signo signoResultado = Interpretador.interpretar(posicaoDia, posicaoMes);
                Bundle args = new Bundle();
                args.putSerializable("resultado", signoResultado);
                Intent intent = new Intent(Principal.this, Resultado.class);
                intent.putExtra("signo", args);
                startActivity(intent);
            }
        });


    }
}
