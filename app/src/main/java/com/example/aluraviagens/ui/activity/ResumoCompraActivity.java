package com.example.aluraviagens.ui.activity;
//--------------------------------------------------------------------------------------------------
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aluraviagens.R;
import com.example.aluraviagens.model.Pacote;
import com.example.aluraviagens.util.DataUtil;
import com.example.aluraviagens.util.MoedaUtil;
import com.example.aluraviagens.util.ResourceUtil;

import java.math.BigDecimal;
//--------------------------------------------------------------------------------------------------
public class ResumoCompraActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo Compra";

    //--------------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);
        setTitle(TITULO_APPBAR);

        Intent intent = getIntent();

        if(intent.hasExtra("pacote")) {
            Pacote pacote = (Pacote) intent.getSerializableExtra("pacote");
            mostra_local(pacote);
            mostra_imagem(pacote);
            mostra_periodo(pacote);
            mostra_preco(pacote);
        }
    }
    //--------------------------------------------------------------------------------------------------
    private void mostra_preco(Pacote pacote) {
        TextView preco = findViewById(R.id.textView_resumoCompra_valorResumo);
        String moeda = MoedaUtil.formataMoeda(pacote.getPreco());
        preco.setText(moeda);
    }
    //--------------------------------------------------------------------------------------------------
    private void mostra_periodo(Pacote pacote) {
        TextView periodo = findViewById(R.id.textView_resumoCompra_periodoPacote);
        String periodoEmTexto = DataUtil.periodoEmTexto(pacote.getDias());
        periodo.setText(periodoEmTexto);
    }
    //--------------------------------------------------------------------------------------------------
    private void mostra_imagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.imageView_resumoCompra_pacoteLocal);
        Drawable imagemPacote = ResourceUtil.retornaDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(imagemPacote);
    }
    //--------------------------------------------------------------------------------------------------
    private void mostra_local(Pacote pacote) {
        TextView local = findViewById(R.id.textView_resumoCompra_localPacote);
        local.setText(pacote.getLocal());
    }
    //--------------------------------------------------------------------------------------------------
}