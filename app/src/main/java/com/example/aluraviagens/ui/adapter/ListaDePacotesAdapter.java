package com.example.aluraviagens.ui.adapter;
//--------------------------------------------------------------------------------------------------
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.aluraviagens.util.DiasUtil;
import com.example.aluraviagens.util.MoedaUtil;
import com.example.aluraviagens.R;
import com.example.aluraviagens.util.ResourceUtil;
import com.example.aluraviagens.model.Pacote;
import java.util.List;
//--------------------------------------------------------------------------------------------------
public class ListaDePacotesAdapter extends BaseAdapter {
    //--------------------------------------------------------------------------------------------------
    //COLOCANDO COMO ATRIBUTO DA CLASSE
    private final List<Pacote> pacotes;
    private final Context context;
    //--------------------------------------------------------------------------------------------------
    //CONSTRUTOR
    public ListaDePacotesAdapter(List<Pacote> pacotes, Context context) {
        this.pacotes = pacotes;
        this.context = context;
    }
    //--------------------------------------------------------------------------------------------------
    //METODOS SOBREESCRITOS PARA CONFIGURAR A LISTA
    @Override
    public int getCount() {
        return pacotes.size();
    }
    //--------------------------------------------------------------------------------------------------
    @Override
    public Pacote getItem(int position) {
        return pacotes.get(position);
    }
    //--------------------------------------------------------------------------------------------------
    @Override
    public long getItemId(int position) {
        return 0;
    }
    //--------------------------------------------------------------------------------------------------
    @Override
    public View getView(int posicao, View view, ViewGroup parent) {
        View viewCriada = LayoutInflater.from(context)
                .inflate(R.layout.item_pacote, parent, false);
//--------------------------------------------------------------------------------------------------
        Pacote pacote = pacotes.get(posicao);
//--------------------------------------------------------------------------------------------------
        mostraImagem(viewCriada, pacote);
//--------------------------------------------------------------------------------------------------
        mostraCidade(viewCriada, pacote);
//--------------------------------------------------------------------------------------------------
        mostraDia(viewCriada, pacote);
//--------------------------------------------------------------------------------------------------
        mostraPreco(viewCriada, pacote);
//--------------------------------------------------------------------------------------------------
        return viewCriada;
    }
    //--------------------------------------------------------------------------------------------------
    private void mostraPreco(View viewCriada, Pacote pacote) {
        TextView preco = viewCriada.findViewById(R.id.item_textview_preco);
        String moedaBrasileira = MoedaUtil.formataMoeda(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }
    //--------------------------------------------------------------------------------------------------
    private void mostraDia(View viewCriada, Pacote pacote) {
        TextView dias = viewCriada.findViewById(R.id.item_textview_dias);
        String diasEmTexto = DiasUtil.formataDiaTexto(pacote.getDias());
        dias.setText(diasEmTexto);
    }
    //--------------------------------------------------------------------------------------------------
    private void mostraImagem(View viewCriada, Pacote pacote) {
        ImageView foto = viewCriada.findViewById(R.id.item_imageview_foto);
        Drawable drawableImagemPacote = ResourceUtil.retornaDrawable(context, pacote.getImagem());
        foto.setImageDrawable(drawableImagemPacote);
    }
    //--------------------------------------------------------------------------------------------------
    private void mostraCidade(View viewCriada, Pacote pacote) {
        TextView local = viewCriada.findViewById(R.id.item_textview_cidade);
        local.setText(pacote.getLocal());
    }
    //--------------------------------------------------------------------------------------------------
}
