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
import adrianmmudarra.es.tema4_json_acdat.model.bizi.Bizi;
import adrianmmudarra.es.tema4_json_acdat.model.bizi.Result;

public class RecyclerBiziAdapter extends RecyclerView.Adapter<RecyclerBiziAdapter.BiziViewHolder> implements View.OnClickListener {

    private ArrayList<Result> repo;
    private Context context;
    private View.OnClickListener listener;


    public RecyclerBiziAdapter(Context c, View.OnClickListener listener){
        this.repo = new ArrayList<>();
        this.context = c;
        this.listener = listener;
    }

    @NonNull
    @Override
    public BiziViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = ((LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.bizi_item,viewGroup,false);
        v.setOnClickListener(this);
        return new BiziViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BiziViewHolder biziViewHolder, int i) {
        biziViewHolder.tv_id.setText("ID parada: "+repo.get(i).getId());
        biziViewHolder.tv_calle.setText(repo.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return this.repo.size();
    }

    public Result getItem(int pos){
        return this.repo.get(pos);
    }

    public void clear(){
        this.repo.clear();
    }

    public void addAll(List<Result> all){
        this.repo.addAll(all);
    }

    @Override
    public void onClick(View v) {
        this.listener.onClick(v);
    }

    class BiziViewHolder extends RecyclerView.ViewHolder {

        TextView tv_id;
        TextView tv_calle;

        BiziViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_calle = itemView.findViewById(R.id.tv_bizi_item_calle);
            tv_id = itemView.findViewById(R.id.tv_bizi_item_id);
        }
    }

}
