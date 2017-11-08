package br.com.vinypaulino.mobile.signosnew;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        // obtemos o bundle que contém o signo e foi recebido pelo intent;
        Bundle args = getIntent().getBundleExtra("signo");
        if (args != null) {
            //obtemos um objeto do tipo Signo que foi passado por parâmetro no bundle
            Signo signoRecebido = (Signo) args.getSerializable("resultado");

            //obtemos uma referência à imagem que está contida na pasta drawable. Para isso usamos o nome da imagem, que está definido no objeto Signo;
            int imageResource = getResources().getIdentifier(
                    signoRecebido.getImagem(),
                    null,
                    getPackageName());
            // atribuímos a imagem do signo ao ImageView, exibindo assim a imagem na tela;
            Drawable res = getDrawable(imageResource);
            ImageView imagem_signo = (ImageView) findViewById(R.id.imageSigno);
            imagem_signo.setImageDrawable(res);

            //  exibimos nos objetos TextView os dados do signo recebido por parâmetro.
            TextView resultado = (TextView) findViewById(R.id.textSigno);
            TextView datas = (TextView) findViewById(R.id.textData);
            resultado.setText(signoRecebido.getNome());
            datas.setText("de " + signoRecebido.getDiaInicio() +
                    "/" + signoRecebido.getMesInicio() +
                    " até " + signoRecebido.getDiaFim() +
                    "/" + signoRecebido.getMesFim());
        }
        // cria uma variável do tipo Button que fará referência ao widget Button localizado no arquivo activity_resultado.xml.
        Button voltar = (Button) findViewById(R.id.buttonVoltar);
        voltar.setOnClickListener(new View.OnClickListener(){
            //tratamos o evento de clique do botão usando o método setOnClickListener, que recebe uma função como parâmetro que será executada quando o evento for disparado;
            @Override
            public void onClick(View view) {
             // finalizamos a activity atual, voltando para a anterior
                finish();
            }
        });

    }
}
