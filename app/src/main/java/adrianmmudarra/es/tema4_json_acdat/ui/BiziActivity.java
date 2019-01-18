package adrianmmudarra.es.tema4_json_acdat.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import adrianmmudarra.es.tema4_json_acdat.R;
import adrianmmudarra.es.tema4_json_acdat.adapter.ApiAdapterBizi;
import adrianmmudarra.es.tema4_json_acdat.adapter.RecyclerBiziAdapter;
import adrianmmudarra.es.tema4_json_acdat.model.bizi.Bizi;
import adrianmmudarra.es.tema4_json_acdat.network.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BiziActivity extends AppCompatActivity  implements View.OnClickListener {

    RecyclerView recyclerView;
    RecyclerBiziAdapter adapter;
    ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bizi);
        inicializacion();
    }

    private void inicializacion() {
        recyclerView = findViewById(R.id.recycler);
        adapter = new RecyclerBiziAdapter(this,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setOnClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        apiService = ApiAdapterBizi.getInstance();
        
        descargarBizis();
    }

    private void descargarBizis() {
        Call<Bizi> call = apiService.getBizis();
        call.enqueue(new Callback<Bizi>() {
            @Override
            public void onResponse(Call<Bizi> call, Response<Bizi> response) {
                adapter.addAll(response.body().getResult());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Bizi> call, Throwable t) {
                mostrarMensaje(t.getMessage());
            }
        });
    }

    private void mostrarMensaje(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(BiziActivity.this, EstacionActivity.class);
        Bundle b = new Bundle();
        b.putSerializable(EstacionActivity.KEY,adapter.getItem(recyclerView.getChildAdapterPosition(v)));
        i.putExtra(EstacionActivity.KEY,b);
        startActivity(i);
    }
}
