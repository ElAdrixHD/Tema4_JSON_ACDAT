package adrianmmudarra.es.tema4_json_acdat.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import adrianmmudarra.es.tema4_json_acdat.R;
import adrianmmudarra.es.tema4_json_acdat.adapter.ApiAdapter;
import adrianmmudarra.es.tema4_json_acdat.model.conversor.Conversor;
import adrianmmudarra.es.tema4_json_acdat.model.conversor.Monedas;
import adrianmmudarra.es.tema4_json_acdat.network.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConversorActivity extends AppCompatActivity {
    //https://openexchangerates.org/api/latest.json?app_id=5e13a5472b5142da85712a7480fdfa4c

    SearchableSpinner spinnerOrigen, spinnerDestino;
    EditText ed_importe;
    Button btn_convertir;
    TextView tv_importe, tv_moneda, tv_errores;
    ApiService apiService;

    ArrayAdapter<String> adapter;
    ArrayList<String> arraymonedas;
    Map<String, String> diccionarioMonedas;
    Map<String, Double> diccionarioConversiones;

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

        descargarMonedas();

        btn_convertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hacerConversion();
            }
        });
    }

    private void hacerConversion() {
        Double importe = Double.parseDouble(ed_importe.getText().toString());
        Double result;
        if(ed_importe.getText().toString() == ""){
            mostrarMensaje("Introduce un valor válido");
            return;
        }
        descargarConversion();
        String claveOrigen = getClave(spinnerOrigen.getSelectedItem().toString());
        String claveDestino = getClave(spinnerDestino.getSelectedItem().toString());
        if(claveOrigen == "USD"){
            result = diccionarioConversiones.get(claveDestino) * importe;
        }else {
            result = (diccionarioConversiones.get(claveOrigen) / importe) * diccionarioConversiones.get(claveDestino);
        }
        tv_importe.setText(result.toString());
    }

    private void descargarConversion() {
        apiService = ApiAdapter.getInstanceMoneda();
        Call<Conversor> call = apiService.getConversion(APPID);
        call.enqueue(new Callback<Conversor>() {
            @Override
            public void onResponse(Call<Conversor> call, Response<Conversor> response) {
                String rates = response.body().getRates().toString();
                String stringrates = rates.substring(rates.indexOf("[")+1,rates.indexOf("]"));
                diccionarioConversiones = new HashMap<>();
                String[] pairs = stringrates.split(",");
                for (String pair : pairs) {
                    String[] keyValue = pair.split("=");
                    diccionarioConversiones.put(keyValue[0].toUpperCase(),Double.parseDouble(keyValue[1]));
                }
            }

            @Override
            public void onFailure(Call<Conversor> call, Throwable t) {
                if (t != null)
                    mostrarMensaje("Fallo en la comunicación:\n" + t.getMessage());
            }
        });
    }

    private String getClave(String s) {
        String result = null;
        for(Map.Entry<String, String> d : diccionarioMonedas.entrySet()){
            if (Objects.equals(s, d.getValue())) {
                result = d.getKey();
            }
        }
        return result;
    }

    private void descargarMonedas() {
        apiService = ApiAdapter.getInstanceMoneda();
        Call<Monedas> call = apiService.getMonedas(APPID);
        call.enqueue(new Callback<Monedas>() {
            @Override
            public void onResponse(Call<Monedas> call, Response<Monedas> response) {
                String monedas = response.body().toString();
                String stringMonedas = monedas.substring(monedas.indexOf("[")+1,monedas.indexOf("]"));
                diccionarioMonedas = new HashMap<>();
                String[] pairs = stringMonedas.split(",");
                for (String pair : pairs) {
                    String[] keyValue = pair.split("=");
                    diccionarioMonedas.put(keyValue[0].toUpperCase(),keyValue[1]);
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
