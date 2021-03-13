package com.example.aluraviagens.ui.activity;
//--------------------------------------------------------------------------------------------------
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.aluraviagens.R;
import com.example.aluraviagens.dao.PacoteDAO;
import com.example.aluraviagens.model.Pacote;
import com.example.aluraviagens.ui.adapter.ListaDePacotesAdapter;

import java.util.List;
//--------------------------------------------------------------------------------------------------
public class ListaDePacotesActivity extends AppCompatActivity {
    public static final String TITULO_APPBAR = "Pacotes";
    //--------------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(TITULO_APPBAR);
        setContentView(R.layout.activity_lista_de_pacotes);
        configuraLista();
    }
    //--------------------------------------------------------------------------------------------------
    private void configuraLista() {
        ListView listaDePacotes = findViewById(R.id.listview_pacotes);
        final List<Pacote> pacotes = new PacoteDAO().lista();
        listaDePacotes.setAdapter(new ListaDePacotesAdapter(pacotes, this));
        //--------------------------------------------------------------------------------------------------
        //INTERACAO CLIQUE
        listaDePacotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListaDePacotesActivity.this, ResumoPacoteActivity.class);
                //ENVIANDO ITEM ENTRE AS ACTIVITY
                Pacote pacoteSelecionado = pacotes.get(position);
                intent.putExtra("pacote",pacoteSelecionado);
                startActivity(intent);


            }
        });
    }
    //--------------------------------------------------------------------------------------------------
}