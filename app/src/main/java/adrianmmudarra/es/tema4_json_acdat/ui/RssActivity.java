package adrianmmudarra.es.tema4_json_acdat.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import adrianmmudarra.es.tema4_json_acdat.R;
import adrianmmudarra.es.tema4_json_acdat.adapter.ApiAdapter;
import adrianmmudarra.es.tema4_json_acdat.adapter.RecyclerRssAdapter;
import adrianmmudarra.es.tema4_json_acdat.model.rss.Feed;
import adrianmmudarra.es.tema4_json_acdat.network.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RssActivity extends AppCompatActivity implements View.OnClickListener {

    /*
    https://www.abc.es/rss/feeds/abc_ultima.xml
    https://www.europapress.es/rss/rss.aspx
    https://www.20minutos.es/rss/
    http://api2.rtve.es/rss/temas_noticias.xml
    http://ep00.epimg.net/rss/tags/ultimas_noticias.xml
    http://feeds2.feedburner.com/libertaddigital/portada
    https://www.lavozdigital.es/rss/feeds/lavozdigital_ultima.xml
    https://rss.elconfidencial.com/espana/
    https://e00-elmundo.uecdn.es/elmundo/rss/portada.xml
    https://e00-expansion.uecdn.es/rss/portada.xml
    https://as.com/rss/tags/ultimas_noticias.xml
    https://www.elperiodico.com/es/rss/internacional/rss.xml
     */
    ApiService apiService;
    Button btn_1,btn_2,btn_3,btn_4,btn_5,btn_6;
    RecyclerView recyclerView;
    RecyclerRssAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rss);
        inicializacion();
    }

    private void inicializacion() {
        btn_1 = findViewById(R.id.btn_rss_1);
        btn_2 = findViewById(R.id.btn_rss_2);
        btn_3 = findViewById(R.id.btn_rss_3);
        btn_4 = findViewById(R.id.btn_rss_4);
        btn_5 = findViewById(R.id.btn_rss_5);
        btn_6 = findViewById(R.id.btn_rss_6);
        recyclerView = findViewById(R.id.recycler_rss);
        adapter = new RecyclerRssAdapter(this,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setOnClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        btn_1.setOnClickListener(v-> onClickBoton(v));
        btn_2.setOnClickListener(v-> onClickBoton(v));
        btn_3.setOnClickListener(v-> onClickBoton(v));
        btn_4.setOnClickListener(v-> onClickBoton(v));
        btn_5.setOnClickListener(v-> onClickBoton(v));
        btn_6.setOnClickListener(v-> onClickBoton(v));
    }

    public void onClickBoton(View view) {
        switch (view.getId()){
            case R.id.btn_rss_1:
                apiService = ApiAdapter.getInstanceRss("https://www.abc.es/");
                descargarXML("rss/feeds/abc_ultima.xml");
                break;
            case R.id.btn_rss_2:
                apiService = ApiAdapter.getInstanceRss("https://www.europapress.es/");
                descargarXML("rss/rss.aspx");
                break;
            case R.id.btn_rss_3:
                apiService = ApiAdapter.getInstanceRss("http://ep00.epimg.net/");
                descargarXML("rss/tags/ultimas_noticias.xml");
                break;
            case R.id.btn_rss_4:
                apiService = ApiAdapter.getInstanceRss("http://feeds2.feedburner.com/");
                descargarXML("libertaddigital/portada");
                break;
            case R.id.btn_rss_5:
                apiService = ApiAdapter.getInstanceRss("https://www.lavozdigital.es/");
                descargarXML("rss/feeds/lavozdigital_ultima.xml");
                break;
            case R.id.btn_rss_6:
                apiService = ApiAdapter.getInstanceRss("https://as.com/");
                descargarXML("rss/tags/ultimas_noticias.xml");
                break;
        }
    }

    private void descargarXML(String s) {
        Call<Feed> call = apiService.getRss(s);
        call.enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {
                adapter.clear();
                adapter.addAll(response.body().getmChannel().getFeedItems());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {
                mostrarMensaje(t.getMessage());
            }
        });
    }

    private void mostrarMensaje(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {

    }
}
