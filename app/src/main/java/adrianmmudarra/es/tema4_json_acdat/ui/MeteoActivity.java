package adrianmmudarra.es.tema4_json_acdat.ui;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import adrianmmudarra.es.tema4_json_acdat.R;
import adrianmmudarra.es.tema4_json_acdat.model.Ciudad;
import adrianmmudarra.es.tema4_json_acdat.model.Tiempo;
import adrianmmudarra.es.tema4_json_acdat.network.ApiService;
import adrianmmudarra.es.tema4_json_acdat.network.RestClient;
import adrianmmudarra.es.tema4_json_acdat.utils.Analysis;
import cz.msebera.android.httpclient.Header;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MeteoActivity extends AppCompatActivity {

    private final String unidades = "metric";
    private final String appid = "8c8452ba700cbab5cd5c81d6cb3dd338";

    SearchableSpinner spinner;
    ArrayAdapter<Ciudad> adapter;
    ArrayList<Ciudad> ciudades;
    ApiService apiService;
    TextView txt_ciudad, txt_temperatura, txt_fecha, txt_viento, txt_nubes, txt_presion, txt_humedad, txt_amanecer, txt_anochecer, txt_minmax;

    private static final String URL_city = "http://adrianm.alumno.mobi/city.list.json";
    private static final String URL_TIEMPO = "https://api.openweathermap.org/";
    //"http://api.openweathermap.org/data/2.5/weather?id={id}&units=metric&APPID=8c8452ba700cbab5cd5c81d6cb3dd338";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meteo);
        inicializacion();
    }

    private void inicializacion() {
        txt_amanecer = findViewById(R.id.txt_meteo_amanecer);
        txt_anochecer = findViewById(R.id.txt_meteo_anochecer);
        txt_ciudad = findViewById(R.id.txt_meteo_ciudad);
        txt_fecha = findViewById(R.id.txt_meteo_fecha);
        txt_humedad = findViewById(R.id.txt_meteo_humedad);
        txt_nubes = findViewById(R.id.txt_meteo_nubes);
        txt_presion = findViewById(R.id.txt_meteo_presion);
        txt_viento = findViewById(R.id.txt_meteo_viento);
        txt_temperatura = findViewById(R.id.txt_meteo_tiempo);
        txt_minmax = findViewById(R.id.txt_meteo_minmax);

        spinner = findViewById(R.id.spiner_ej1);
        spinner.setTitle("Seleccione una ciudad");
        spinner.setPositiveButton("OK");
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .build();

        Gson gson = new GsonBuilder()
                .setDateFormat("dd-MM-yyyy")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_TIEMPO)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();

        apiService = retrofit.create(ApiService.class);

        descargarJsonCiudades();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                descargarTiempoCiudad(((Ciudad) parent.getSelectedItem()).getId());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });
    }

    private void descargarTiempoCiudad(int id) {
        Call<Tiempo> call = apiService.getTiempo(Integer.toString(id), unidades, appid);
        call.enqueue(new Callback<Tiempo>() {
            @Override
            public void onResponse(Call<Tiempo> call, Response<Tiempo> response) {
                if (response.isSuccessful()) {
                    try{
                        txt_ciudad.setText(response.body().getName() + ", " + response.body().getSys().getCountry());
                        txt_temperatura.setText(Integer.toString((int) Math.round(response.body().getMain().getTemp())) + "ºC");
                        txt_fecha.setText(new Date((long) response.body().getDt() * 1000).toString());
                        txt_viento.setText(Double.toString(response.body().getWind().getSpeed()) + " m/s (" + Double.toString(response.body().getWind().getDeg()) + "º)");
                        txt_nubes.setText(response.body().getWeather().get(0).getDescription());
                        txt_presion.setText(Integer.toString((int) Math.round(response.body().getMain().getPressure())) + " hpa");
                        txt_humedad.setText(Integer.toString((int) Math.round(response.body().getMain().getHumidity())) + "%");
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(new Date((long) response.body().getSys().getSunrise() * 1000));
                        txt_amanecer.setText(Integer.toString(calendar.get(Calendar.HOUR_OF_DAY)) + ":" + Integer.toString(calendar.get(Calendar.MINUTE)));
                        calendar.setTime(new Date((long) response.body().getSys().getSunset() * 1000));
                        txt_anochecer.setText(Integer.toString(calendar.get(Calendar.HOUR_OF_DAY)) + ":" + Integer.toString(calendar.get(Calendar.MINUTE)));
                        txt_minmax.setText("("+Integer.toString((int) Math.round(response.body().getMain().getTempMin()))+"ºC / "+Integer.toString((int) Math.round(response.body().getMain().getTempMax()))+"ºC)");
                    }catch (Exception e){
                        txt_ciudad.setText("");
                        txt_temperatura.setText("");
                        txt_fecha.setText("");
                        txt_viento.setText("");
                        txt_nubes.setText("");
                        txt_presion.setText("");
                        txt_humedad.setText("");
                        txt_amanecer.setText("");
                        txt_anochecer.setText("");
                        txt_minmax.setText("");
                        mostrarMensaje("Ha ocurrido un error al mostrar los datos de esta ciudad... Pruebe con otra o intentelo mas tarde.");
                    }

                } else {
                    StringBuilder message = new StringBuilder();
                    message.append("Error en la descarga: " + response.code());
                    if (response.body() != null)
                        message.append("\n" + response.body());
                    if (response.errorBody() != null)
                        try {
                            message.append("\n" + response.errorBody().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    mostrarMensaje(message.toString());
                }
            }

            @Override
            public void onFailure(Call<Tiempo> call, Throwable t) {
                if (t != null)
                    mostrarMensaje("Fallo en la comunicación:\n" + t.getMessage());
            }
        });
    }

    private void descargarJsonCiudades() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        RestClient.get(URL_city, new JsonHttpResponseHandler() {
            @Override
            public void onStart() {
                super.onStart();
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.setMessage("Cargando datos. Espere un momento.");
                progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    public void onCancel(DialogInterface dialog) {
                        RestClient.cancelRequests(getApplicationContext(), true);
                    }
                });
                progressDialog.show();

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
                progressDialog.dismiss();
                try {
                    ciudades = Analysis.ciudadesAnalyze(response);
                    if (ciudades != null) {
                        adapter.clear();
                        adapter.addAll(ciudades);
                    }
                } catch (JSONException e) {
                    mostrarMensaje(e.getMessage());
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                progressDialog.dismiss();
                mostrarMensaje(throwable.getMessage());
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
                progressDialog.dismiss();
                mostrarMensaje(responseString);

            }
        });
    }

    private void mostrarMensaje(String mensaje) {
        Toast.makeText(MeteoActivity.this, mensaje, Toast.LENGTH_LONG).show();
    }
}
