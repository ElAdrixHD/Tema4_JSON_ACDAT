package adrianmmudarra.es.tema4_json_acdat.ui;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import adrianmmudarra.es.tema4_json_acdat.model.api.Producto;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import adrianmmudarra.es.tema4_json_acdat.R;
import adrianmmudarra.es.tema4_json_acdat.adapter.ApiAdapter;
import adrianmmudarra.es.tema4_json_acdat.model.api.Cooperativa;
import adrianmmudarra.es.tema4_json_acdat.network.ApiService;
import adrianmmudarra.es.tema4_json_acdat.utils.DatePickerFragment;

public class MiApiActivity extends AppCompatActivity {

    EditText selectFecha;
    Spinner spinnerCoop, spinnerProd;
    ArrayAdapter<Cooperativa> adapterCooperativa;
    ArrayAdapter<Producto> adapterProducto;
    ArrayList<Cooperativa> arrayListCooperativa;
    ArrayList<Producto> arrayListProducto;
    ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_api);
        inicializacion();
    }

    private void inicializacion() {
        spinnerCoop = findViewById(R.id.spinner_api_coop);
        spinnerProd = findViewById(R.id.spinner_api_prod);
        selectFecha = findViewById(R.id.ed_api_fecha);
        selectFecha.setOnClickListener(view -> {
            mostrarPicker();
        });
        arrayListCooperativa = new ArrayList<>();
        arrayListProducto = new ArrayList<>();
        apiService = ApiAdapter.getInstanceApi();

        adapterCooperativa = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        adapterProducto = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        adapterCooperativa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterProducto.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCoop.setAdapter(adapterCooperativa);
        spinnerProd.setAdapter(adapterProducto);
        descargarSpinners();
    }

    private void descargarSpinners() {
        Call<List<Cooperativa>> callcoop = apiService.getCooperativas();
        callcoop.enqueue(new Callback<List<Cooperativa>>() {
            @Override
            public void onResponse(Call<List<Cooperativa>> call, Response<List<Cooperativa>> response) {
                adapterCooperativa.clear();
                adapterCooperativa.addAll(response.body());
                adapterCooperativa.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Cooperativa>> call, Throwable t) {
                mostrarMensaje(t.getMessage());
            }
        });

        Call<List<Producto>> callprod = apiService.getProductos();
        callprod.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
                adapterProducto.clear();
                adapterProducto.addAll(response.body());
                adapterProducto.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {
                mostrarMensaje(t.getMessage());
            }
        });
    }

    private void mostrarPicker() {
        DatePickerFragment newFragment = DatePickerFragment.newInstance((datePicker, anio, mes, dia) -> {
            NumberFormat format = new DecimalFormat("00");
            final String selectedDate = format.format(dia) + "-" + format.format((mes+1)) + "-" + Integer.toString(anio).substring(2);
            selectFecha.setText(selectedDate);
        });
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    private void mostrarMensaje(String mensaje) {
        Toast.makeText(MiApiActivity.this, mensaje, Toast.LENGTH_LONG).show();
    }
}
