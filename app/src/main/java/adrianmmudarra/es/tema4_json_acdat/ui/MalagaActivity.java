package adrianmmudarra.es.tema4_json_acdat.ui;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.loopj.android.http.FileAsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import adrianmmudarra.es.tema4_json_acdat.R;
import adrianmmudarra.es.tema4_json_acdat.adapter.ApiAdapterMalaga;
import adrianmmudarra.es.tema4_json_acdat.adapter.RecyclerMalagaAdapter;
import adrianmmudarra.es.tema4_json_acdat.model.malaga.BiciMalaga;
import adrianmmudarra.es.tema4_json_acdat.network.ApiService;
import adrianmmudarra.es.tema4_json_acdat.network.RestClient;
import cz.msebera.android.httpclient.Header;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MalagaActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, View.OnClickListener {

    File miCSV;
    File miJSON;
    final String url = "https://datosabiertos.malaga.eu/recursos/transporte/EMT/EMTocupestacbici/ocupestacbici.csv";
    final static String WEB = "http://adrianm.alumno.mobi/upload.php";
    Pattern pattern = Pattern.compile(",");
    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;
    RecyclerMalagaAdapter adapter;
    ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_malaga);
        ComprobarPermisos();
        inicializar();
    }

    private void inicializar() {
        swipeRefreshLayout = findViewById(R.id.swipe);
        recyclerView = findViewById(R.id.recycler);
        swipeRefreshLayout.setOnRefreshListener(this);
        adapter = new RecyclerMalagaAdapter(this,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setOnClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        apiService = ApiAdapterMalaga.getInstance();
        mostrarJSON();
        mostrarMensaje("Arrastre hacia abajo para recargar");
    }

    private void mostrarJSON() {
        Call<List<BiciMalaga>> call = apiService.getBicisMalaga();
        call.enqueue(new Callback<List<BiciMalaga>>() {
            @Override
            public void onResponse(Call<List<BiciMalaga>> call, Response<List<BiciMalaga>> response) {
                adapter.clear();
                adapter.addAll(response.body());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<BiciMalaga>> call, Throwable t) {
                mostrarMensaje(t.getMessage());
            }
        });
    }

    private void ComprobarPermisos() {
        if (ActivityCompat.checkSelfPermission(MalagaActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
            //pedir los permisos necesarios si no están concedidos.
            ActivityCompat.requestPermissions(MalagaActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        else {
            descargarFichero();
        }
    }


    private void descargarFichero() {
        miCSV = new File(Environment.getExternalStorageDirectory().getAbsolutePath(),"ocupestabici.csv");

        RestClient.get(url, new FileAsyncHttpResponseHandler(miCSV) {

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, File file) {
                mostrarMensaje(throwable.getMessage());
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, File file) {
                leerCSV();
            }
        });

    }

    private void leerCSV() {
        miJSON = new File(Environment.getExternalStorageDirectory().getAbsolutePath(),"bicis.json");
        try (BufferedReader in = new BufferedReader(new FileReader(miCSV))) {
            List<BiciMalaga> bicis = in .lines() .skip(1) .map(line -> {
                String[] x = pattern.split(line);
                return new BiciMalaga(x[0].replace("\"",""), x[1].replace("\"",""), x[2].replace("\"",""), x[3].replace("\"",""), x[4].replace("\"",""), x[5].replace("\"",""), x[6].replace("\"",""),x[7].replace("\"",""),x[8].replace("\"",""), x[9].replace("\"",""), x[10].replace("\"",""),x[11].replace("\"",""));
            }) .collect(Collectors.toList());
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(miJSON, bicis);
            subirJSON();
        } catch (FileNotFoundException e) {
            mostrarMensaje(e.getMessage());
        } catch (IOException e) {
            mostrarMensaje(e.getMessage());
        }
    }

    private void subirJSON(){
        RequestParams params = new RequestParams();
        try {
            params.put("fileToUpload",miJSON);

            RestClient.post(WEB, params, new TextHttpResponseHandler() {
                @Override
                public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                    mostrarMensaje(responseString);
                }

                @Override
                public void onSuccess(int statusCode, Header[] headers, String responseString) {
                }
            });
        } catch (FileNotFoundException e) {
            mostrarMensaje(e.getMessage());
        }
    }

    private void mostrarMensaje(String message) {
        Toast.makeText(MalagaActivity.this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if (ActivityCompat.checkSelfPermission(MalagaActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
                    descargarFichero();
                    else
                        mostrarMensaje("No hay permisos");
                break;
        }
    }


    @Override
    public void onRefresh() {
        descargarFichero();
        mostrarJSON();
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onClick(View v) {

    }
}
