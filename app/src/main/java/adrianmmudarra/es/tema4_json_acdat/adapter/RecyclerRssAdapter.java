package adrianmmudarra.es.tema4_json_acdat.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import adrianmmudarra.es.tema4_json_acdat.R;
import adrianmmudarra.es.tema4_json_acdat.model.rss.FeedItem;

public class RecyclerRssAdapter extends RecyclerView.Adapter<RecyclerRssAdapter.RssViewHolder> implements View.OnClickListener{

    private ArrayList<FeedItem> repo;
    private Context context;
    private View.OnClickListener listener;

    public RecyclerRssAdapter(Context context, View.OnClickListener listener) {
        this.repo = new ArrayList<>();
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RssViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = ((LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.rss_item,viewGroup,false);
        return new RecyclerRssAdapter.RssViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RssViewHolder rssViewHolder, int i) {
        rssViewHolder.tv_titulo.setText(repo.get(i).getMtitle());
        rssViewHolder.tv_fecha.setText(repo.get(i).getMpubDate());
        rssViewHolder.tv_descripcion.setText(repo.get(i).getMdescription());
    }

    @Override
    public int getItemCount() {
        return repo.size();
    }

    public FeedItem getItem(int pos){
        return this.repo.get(pos);
    }

    public void clear(){
        this.repo.clear();
    }

    public void addAll(List<FeedItem> all){
        this.repo.addAll(all);
    }

    @Override
    public void onClick(View view) {
        this.listener.onClick(view);
    }

    class RssViewHolder extends RecyclerView.ViewHolder {

        TextView tv_titulo,tv_fecha,tv_descripcion;

        RssViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_titulo = itemView.findViewById(R.id.tv_rrs_item_titulo);
            tv_fecha = itemView.findViewById(R.id.tv_rss_item_fecha);
            tv_descripcion = itemView.findViewById(R.id.tv_rss_item_descripcion);
        }
    }
}


