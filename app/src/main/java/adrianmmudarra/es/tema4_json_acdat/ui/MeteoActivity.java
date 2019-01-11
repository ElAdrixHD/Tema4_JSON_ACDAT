package adrianmmudarra.es.tema4_json_acdat.ui;

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

import com.loopj.android.http.JsonHttpResponseHandler;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import adrianmmudarra.es.tema4_json_acdat.R;
import adrianmmudarra.es.tema4_json_acdat.model.Ciudad;
import adrianmmudarra.es.tema4_json_acdat.network.RestClient;
import adrianmmudarra.es.tema4_json_acdat.utils.Analysis;
import cz.msebera.android.httpclient.Header;

public class MeteoActivity extends AppCompatActivity {

    SearchableSpinner spinner;
    ArrayAdapter<Ciudad> adapter;
    ArrayList<Ciudad> ciudades;

    private static final String URL_city = "http://adrianm.alumno.mobi/city.list.json";

//https://stackoverflow.com/questions/3371326/java-date-from-unix-timestamp
    private static final String URL = "http://api.openweathermap.org/data/2.5/weather?q=madrid,es&units=metric&APPID=8c8452ba700cbab5cd5c81d6cb3dd338";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meteo);
        inicializacion();
    }

    private void inicializacion() {
        spinner = findViewById(R.id.spiner_ej1);
        spinner.setTitle("Seleccione una ciudad");
        spinner.setPositiveButton("OK");
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        descargarJsonCiudades();
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //((Ciudad) parent.getSelectedItem()).
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });
    }

    private void descargarJsonCiudades() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        RestClient.get(URL_city, new JsonHttpResponseHandler(){
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

    private void mostrarMensaje(String mensaje){
        Toast.makeText(MeteoActivity.this, mensaje, Toast.LENGTH_LONG);
    }
}
