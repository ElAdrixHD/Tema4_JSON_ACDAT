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
import adrianmmudarra.es.tema4_json_acdat.model.bizi.Result;
import adrianmmudarra.es.tema4_json_acdat.model.malaga.BiciMalaga;

public class RecyclerMalagaAdapter extends RecyclerView.Adapter<RecyclerMalagaAdapter.MalagaViewHolder> implements View.OnClickListener {
    private ArrayList<BiciMalaga> repo;
    private Context context;
    private View.OnClickListener listener;


    public RecyclerMalagaAdapter(Context c, View.OnClickListener listener){
        this.repo = new ArrayList<>();
        this.context = c;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerMalagaAdapter.MalagaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = ((LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.bizi_item,viewGroup,false);
        v.setOnClickListener(this);
        return new RecyclerMalagaAdapter.MalagaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MalagaViewHolder malagaViewHolder, int i) {
        malagaViewHolder.tv_nombre.setText("ID parada: "+repo.get(i).getNombre());
        malagaViewHolder.tv_dir.setText(repo.get(i).getDireccion());
        malagaViewHolder.tv_libres.setText(repo.get(i).getNumLibres());
        malagaViewHolder.tv_ocupadas.setText(repo.get(i).getNumOcupadas());
    }

    @Override
    public int getItemCount() {
        return this.repo.size();
    }

    public BiciMalaga getItem(int pos){
        return this.repo.get(pos);
    }

    public void clear(){
        this.repo.clear();
    }

    public void addAll(List<BiciMalaga> all){
        this.repo.addAll(all);
    }

    @Override
    public void onClick(View v) {
        this.listener.onClick(v);
    }

    class MalagaViewHolder extends RecyclerView.ViewHolder {

        TextView tv_nombre;
        TextView tv_dir;
        TextView tv_libres;
        TextView tv_ocupadas;

        MalagaViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_nombre = itemView.findViewById(R.id.tv_malaga_nombre);
            tv_dir = itemView.findViewById(R.id.tv_malaga_dir);
            tv_libres = itemView.findViewById(R.id.tv_malaga_libres);
            tv_ocupadas = itemView.findViewById(R.id.tv_malaga_ocupadas);
        }
    }
}
