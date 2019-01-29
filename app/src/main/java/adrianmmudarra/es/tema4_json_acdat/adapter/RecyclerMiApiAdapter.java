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
import adrianmmudarra.es.tema4_json_acdat.model.api.Subasta;
import adrianmmudarra.es.tema4_json_acdat.utils.RepoApi;

public class RecyclerMiApiAdapter extends RecyclerView.Adapter<RecyclerMiApiAdapter.ApiViewHolder> {
    private ArrayList<Subasta> repo;
    private Context context;
    private RepoApi datos;


    public RecyclerMiApiAdapter(Context c, RepoApi d){
        this.repo = new ArrayList<>();
        this.context = c;
        this.datos = d;
    }

    @NonNull
    @Override
    public RecyclerMiApiAdapter.ApiViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = ((LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.api_item,viewGroup,false);
        return new RecyclerMiApiAdapter.ApiViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ApiViewHolder apiViewHolder, int i) {
        apiViewHolder.tv_prod.setText(datos.getNombreProd(repo.get(i).getProducto()));
        apiViewHolder.tv_coop.setText(datos.getNombreCoop(repo.get(i).getCooperativa()));
        apiViewHolder.tv_precios.setText(repo.get(i).toString());
        apiViewHolder.tv_fecha.setText(repo.get(i).getFechaSubasta());
    }

    @Override
    public int getItemCount() {
        return this.repo.size();
    }

    public Subasta getItem(int pos){
        return this.repo.get(pos);
    }

    public void clear(){
        this.repo.clear();
    }

    public void addAll(List<Subasta> all){
        this.repo.addAll(all);
    }


    class ApiViewHolder extends RecyclerView.ViewHolder {

        TextView tv_coop;
        TextView tv_prod;
        TextView tv_precios;
        TextView tv_fecha;

        ApiViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_coop = itemView.findViewById(R.id.tv_api_item_coop);
            tv_precios = itemView.findViewById(R.id.tv_api_item_precios);
            tv_prod = itemView.findViewById(R.id.tv_api_item_prod);
            tv_fecha = itemView.findViewById(R.id.tv_api_item_fecha);
        }
    }
}
