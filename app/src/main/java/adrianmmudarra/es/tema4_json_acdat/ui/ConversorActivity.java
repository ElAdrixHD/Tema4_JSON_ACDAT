package adrianmmudarra.es.tema4_json_acdat.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import adrianmmudarra.es.tema4_json_acdat.R;
import adrianmmudarra.es.tema4_json_acdat.model.conversor.Monedas;
import adrianmmudarra.es.tema4_json_acdat.network.ApiService;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConversorActivity extends AppCompatActivity {
    //https://openexchangerates.org/api/latest.json?app_id=5e13a5472b5142da85712a7480fdfa4c

    SearchableSpinner spinnerOrigen, spinnerDestino;
    EditText ed_importe;
    Button btn_convertir;
    TextView tv_importe, tv_moneda, tv_errores;
    ApiService apiService;

    ArrayAdapter<String> adapter;
    ArrayList<String> arraymonedas;
    Map<String, String> diccionario;

    private static final String URL_MONEDA = "https://openexchangerates.org/";
    private static final String APPID = "5e13a5472b5142da85712a7480fdfa4c";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor);
        inicializacion();
    }

    private void inicializacion() {
        ed_importe = findViewById(R.id.ed_conversor_importe);
        btn_convertir = findViewById(R.id.btn_conversor);
        tv_importe = findViewById(R.id.tv_conversor_importe);
        tv_errores = findViewById(R.id.tv_errores);
        tv_moneda = findViewById(R.id.tv_conversor_simbolo);
        spinnerOrigen = findViewById(R.id.spiner_monedaorigen_ej2);
        spinnerDestino = findViewById(R.id.spiner_monedadestino_ej2);

        arraymonedas = new ArrayList<>();

        spinnerOrigen.setTitle("Moneda que desea entregar");
        spinnerOrigen.setPositiveButton("OK");
        spinnerDestino.setTitle("Moneda que desea recibir");
        spinnerDestino.setPositiveButton("OK");
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOrigen.setAdapter(adapter);
        spinnerDestino.setAdapter(adapter);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .build();

        Gson gson = new GsonBuilder()
                .setDateFormat("dd-MM-yyyy")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_MONEDA)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();

        apiService = retrofit.create(ApiService.class);

        descargarMonedas();
    }

    private void descargarMonedas() {
        Call<Monedas> call = apiService.getMonedas(APPID);
        call.enqueue(new Callback<Monedas>() {
            @Override
            public void onResponse(Call<Monedas> call, Response<Monedas> response) {
                String monedas = response.body().toString();
                String stringMonedas = monedas.substring(monedas.indexOf("[")+1,monedas.indexOf("]"));
                diccionario = new HashMap<>();
                String[] pairs = stringMonedas.split(",");
                for (String pair : pairs) {
                    String[] keyValue = pair.split("=");
                    diccionario.put(keyValue[0],keyValue[1]);
                    arraymonedas.add(keyValue[1]);
                }
                adapter.clear();
                adapter.addAll(arraymonedas);
            }

            @Override
            public void onFailure(Call<Monedas> call, Throwable t) {
                if (t != null)
                    mostrarMensaje("Fallo en la comunicación:\n" + t.getMessage());
            }
        });
    }

    private void mostrarMensaje(String mensaje) {
        Toast.makeText(ConversorActivity.this, mensaje, Toast.LENGTH_LONG).show();
    }
}
