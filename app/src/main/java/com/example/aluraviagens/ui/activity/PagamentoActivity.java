package com.example.aluraviagens.ui.activity;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.aluraviagens.R;
import com.example.aluraviagens.model.Pacote;
import com.example.aluraviagens.util.MoedaUtil;
public class PagamentoActivity extends AppCompatActivity {
    //--------------------------------------------------------------------------------------------------
    public static final String TITULO_APPBAR = "Pagamento";
    //--------------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        setTitle(TITULO_APPBAR);
        carregaPacoteRecebido();
    }
    //--------------------------------------------------------------------------------------------------
    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if(intent.hasExtra("pacote")){
            final Pacote pacote = (Pacote) intent.getSerializableExtra("pacote");
            mostraPreco(pacote);
            configuraBotao(pacote);
        }
    }
    //--------------------------------------------------------------------------------------------------
    private void configuraBotao(Pacote pacote) {
        Button botaoFinalizaCompra = findViewById(R.id.botao_finalizar_compra);
        botaoFinalizaCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              vaiParaResumoCompra(pacote);
            }
        });
    }
    //--------------------------------------------------------------------------------------------------
    private void vaiParaResumoCompra(Pacote pacote) {
        Intent intent = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
        intent.putExtra("pacote",pacote);
        startActivity(intent);
    }
    //--------------------------------------------------------------------------------------------------
    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.textView_precoCompra);
        String realBr = MoedaUtil.formataMoeda(pacote.getPreco());
        preco.setText(realBr);
    }
    //--------------------------------------------------------------------------------------------------
}