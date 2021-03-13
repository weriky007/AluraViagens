package com.example.aluraviagens.ui.activity;
//--------------------------------------------------------------------------------------------------
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aluraviagens.R;
import com.example.aluraviagens.model.Pacote;
import com.example.aluraviagens.util.DataUtil;
import com.example.aluraviagens.util.DiasUtil;
import com.example.aluraviagens.util.MoedaUtil;
import com.example.aluraviagens.util.ResourceUtil;

//--------------------------------------------------------------------------------------------------
public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String RESUMO_DO_PACOTE = "Resumo do Pacote";

    //--------------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);
        setTitle(RESUMO_DO_PACOTE);
        carregaPacoteRecebido();
    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if(intent.hasExtra("pacote")){
            final Pacote pacote = (Pacote) intent.getSerializableExtra("pacote");
            inicializacaoCampos(pacote);
            configuraBotao(pacote);
        }
    }

    //--------------------------------------------------------------------------------------------------
    private void configuraBotao(final Pacote pacote) {
        Button botaoRealizaPagamento = findViewById(R.id.button_realizarPagamentoResumoPacote);
        botaoRealizaPagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vaiParaPagamento(pacote);
            }
        });
    }
    //--------------------------------------------------------------------------------------------------
    private void vaiParaPagamento(Pacote pacote) {
        Intent intent = new Intent(ResumoPacoteActivity.this, PagamentoActivity.class);
        intent.putExtra("pacote", pacote);
        startActivity(intent);
    }
    //--------------------------------------------------------------------------------------------------
    private void inicializacaoCampos(Pacote pacote) {
        mostraLocal(pacote);
        mostraImagem(pacote);
        mostraDias(pacote);
        mostraPreco(pacote);
        mostraData(pacote);
    }
    //--------------------------------------------------------------------------------------------------
    private void mostraData(Pacote pacote) {
        //BIND Processo de acorrentamento de views
        TextView data = findViewById(R.id.textView_periodoResumoPacote);
        String dataFormatadaDaViagem = DataUtil.periodoEmTexto(pacote.getDias());
        data.setText(dataFormatadaDaViagem);
    }
    //--------------------------------------------------------------------------------------------------
    private void mostraPreco(Pacote pacote) {
        TextView precoFinal = findViewById(R.id.textView_precoFinalResumoPacote);
        precoFinal.setText("Preco Final");
        TextView preco = findViewById(R.id.textView_precoResumoPacote);
        String moedaBr = MoedaUtil.formataMoeda(pacote.getPreco());
        preco.setText(moedaBr);
    }
    //--------------------------------------------------------------------------------------------------
    private void mostraDias(Pacote pacote) {
        TextView dias = findViewById(R.id.textView_diasResumoPacote);
        String diasEmTexto = DiasUtil.formataDiaTexto(pacote.getDias());
        dias.setText(diasEmTexto);
    }
    //--------------------------------------------------------------------------------------------------
    private void mostraImagem(Pacote pacote) {
        //Atribui a imagem relacionada ao pacote
        ImageView imagem = findViewById(R.id.imageView_resumoPacote);
        Drawable drawable = ResourceUtil.retornaDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawable);
    }
    //--------------------------------------------------------------------------------------------------
    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.textView_cidadeResumoPacote);
        local.setText(pacote.getLocal());
    }
    //--------------------------------------------------------------------------------------------------
}