package adrianmmudarra.es.tema4_json_acdat.ui;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import adrianmmudarra.es.tema4_json_acdat.adapter.RecyclerMalagaAdapter;
import adrianmmudarra.es.tema4_json_acdat.adapter.RecyclerMiApiAdapter;
import adrianmmudarra.es.tema4_json_acdat.model.api.Producto;
import adrianmmudarra.es.tema4_json_acdat.model.api.Subasta;
import adrianmmudarra.es.tema4_json_acdat.utils.RepoApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import adrianmmudarra.es.tema4_json_acdat.R;
import adrianmmudarra.es.tema4_json_acdat.adapter.ApiAdapter;
import adrianmmudarra.es.tema4_json_acdat.model.api.Cooperativa;
import adrianmmudarra.es.tema4_json_acdat.network.ApiService;
import adrianmmudarra.es.tema4_json_acdat.utils.DatePickerFragment;

public class MiApiActivity extends AppCompatActivity implements RepoApi {

    EditText selectFecha;
    Spinner spinnerCoop, spinnerProd;
    ArrayAdapter<Cooperativa> adapterCooperativa;
    ArrayAdapter<Producto> adapterProducto;
    ArrayList<Cooperativa> arrayListCooperativa;
    ArrayList<Producto> arrayListProducto;
    ApiService apiService;
    Button limpiar, buscar;
    RecyclerView recyclerView;
    RecyclerMiApiAdapter apiAdapter;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_api);
        inicializacion();
    }

    private void inicializacion() {
        recyclerView = findViewById(R.id.recycler_api);
        limpiar = findViewById(R.id.btn_api_limpiar);
        buscar = findViewById(R.id.btn_api_buscar);
        spinnerCoop = findViewById(R.id.spinner_api_coop);
        spinnerProd = findViewById(R.id.spinner_api_prod);
        selectFecha = findViewById(R.id.ed_api_fecha);
        selectFecha.setOnClickListener(view -> mostrarPicker());
        limpiar.setOnClickListener(v -> limpiarDatos());
        buscar.setOnClickListener(v -> buscarDatos());
        arrayListCooperativa = new ArrayList<>();
        arrayListProducto = new ArrayList<>();
        apiAdapter = new RecyclerMiApiAdapter(this,this);
        recyclerView.setAdapter(apiAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        apiService = ApiAdapter.getInstanceApi();

        adapterCooperativa = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        adapterProducto = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        adapterCooperativa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterProducto.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCoop.setAdapter(adapterCooperativa);
        spinnerProd.setAdapter(adapterProducto);
        descargarSpinners();
    }

    private void buscarDatos() {
        if (spinnerCoop.getSelectedItemPosition() == 0 && spinnerProd.getSelectedItemPosition() == 0 && TextUtils.isEmpty(selectFecha.getText())){
            progressDialog = new ProgressDialog(MiApiActivity.this);
            progressDialog.setCancelable(false);
            progressDialog.setIndeterminate(true);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.setMessage("Esta operacion puede tardar un rato. Por favor espere.");
            progressDialog.setTitle("Warning");
            progressDialog.show();
            Call<List<Subasta>> call = apiService.getTodaSubasta();
            call.enqueue(new Callback<List<Subasta>>() {
                @Override
                public void onResponse(Call<List<Subasta>> call, Response<List<Subasta>> response) {
                    apiAdapter.clear();
                    apiAdapter.addAll(response.body());
                    apiAdapter.notifyDataSetChanged();
                    progressDialog.dismiss();
                }

                @Override
                public void onFailure(Call<List<Subasta>> call, Throwable t) {
                    mostrarMensaje(t.getMessage());
                    progressDialog.dismiss();
                }
            });

        }else {
            if (spinnerCoop.getSelectedItemPosition() != 0 && spinnerProd.getSelectedItemPosition() != 0 && TextUtils.isEmpty(selectFecha.getText())){
                Call<List<Subasta>> call = apiService.getSubastaCoopProd(Integer.toString(((Cooperativa)spinnerCoop.getSelectedItem()).getIdCooperativa()),Integer.toString(((Producto)spinnerProd.getSelectedItem()).getIdProducto()));
                call.enqueue(new Callback<List<Subasta>>() {
                    @Override
                    public void onResponse(Call<List<Subasta>> call, Response<List<Subasta>> response) {
                        if (response.isSuccessful()){
                            apiAdapter.clear();
                            apiAdapter.addAll(response.body());
                            apiAdapter.notifyDataSetChanged();
                        }else {
                            apiAdapter.clear();
                            apiAdapter.notifyDataSetChanged();
                            mostrarMensaje(response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Subasta>> call, Throwable t) {
                        mostrarMensaje(t.getMessage());
                    }
                });
            }else {
                if (spinnerCoop.getSelectedItemPosition() == 0 && spinnerProd.getSelectedItemPosition() == 0 && !TextUtils.isEmpty(selectFecha.getText())) {
                    Call<List<Subasta>> call = apiService.getSubastaFecha(selectFecha.getText().toString());
                    call.enqueue(new Callback<List<Subasta>>() {
                        @Override
                        public void onResponse(Call<List<Subasta>> call, Response<List<Subasta>> response) {
                            if (response.isSuccessful()) {
                                apiAdapter.clear();
                                apiAdapter.addAll(response.body());
                                apiAdapter.notifyDataSetChanged();
                            } else {
                                apiAdapter.clear();
                                apiAdapter.notifyDataSetChanged();
                                mostrarMensaje(response.message());
                            }
                        }

                        @Override
                        public void onFailure(Call<List<Subasta>> call, Throwable t) {
                            mostrarMensaje(t.getMessage());
                        }
                    });
                }else {
                    if (spinnerCoop.getSelectedItemPosition() == 0 && spinnerProd.getSelectedItemPosition() != 0 && !TextUtils.isEmpty(selectFecha.getText())) {
                        Call<List<Subasta>> call = apiService.getSubastaFechaProd(selectFecha.getText().toString(),Integer.toString(((Producto)spinnerProd.getSelectedItem()).getIdProducto()));
                        call.enqueue(new Callback<List<Subasta>>() {
                            @Override
                            public void onResponse(Call<List<Subasta>> call, Response<List<Subasta>> response) {
                                if (response.isSuccessful()) {
                                    apiAdapter.clear();
                                    apiAdapter.addAll(response.body());
                                    apiAdapter.notifyDataSetChanged();
                                } else {
                                    apiAdapter.clear();
                                    apiAdapter.notifyDataSetChanged();
                                    mostrarMensaje(response.message());
                                }
                            }

                            @Override
                            public void onFailure(Call<List<Subasta>> call, Throwable t) {
                                mostrarMensaje(t.getMessage());
                            }
                        });
                    }else{
                        if (spinnerCoop.getSelectedItemPosition() != 0 && spinnerProd.getSelectedItemPosition() != 0 && !TextUtils.isEmpty(selectFecha.getText())) {
                            Call<List<Subasta>> call = apiService.getSubastaFechaCoopProd(selectFecha.getText().toString(),Integer.toString(((Cooperativa)spinnerCoop.getSelectedItem()).getIdCooperativa()),Integer.toString(((Producto)spinnerProd.getSelectedItem()).getIdProducto()));
                            call.enqueue(new Callback<List<Subasta>>() {
                                @Override
                                public void onResponse(Call<List<Subasta>> call, Response<List<Subasta>> response) {
                                    if (response.isSuccessful()) {
                                        apiAdapter.clear();
                                        apiAdapter.addAll(response.body());
                                        apiAdapter.notifyDataSetChanged();
                                    } else {
                                        apiAdapter.clear();
                                        apiAdapter.notifyDataSetChanged();
                                        mostrarMensaje(response.message());
                                    }
                                }

                                @Override
                                public void onFailure(Call<List<Subasta>> call, Throwable t) {
                                    mostrarMensaje(t.getMessage());
                                }
                            });
                        }else {
                            if (spinnerCoop.getSelectedItemPosition() == 0 && spinnerProd.getSelectedItemPosition() != 0 && TextUtils.isEmpty(selectFecha.getText())) {
                                Call<List<Subasta>> call = apiService.getSubastaProd(Integer.toString(((Producto)spinnerProd.getSelectedItem()).getIdProducto()));
                                call.enqueue(new Callback<List<Subasta>>() {
                                    @Override
                                    public void onResponse(Call<List<Subasta>> call, Response<List<Subasta>> response) {
                                        if (response.isSuccessful()) {
                                            apiAdapter.clear();
                                            apiAdapter.addAll(response.body());
                                            apiAdapter.notifyDataSetChanged();
                                        } else {
                                            apiAdapter.clear();
                                            apiAdapter.notifyDataSetChanged();
                                            mostrarMensaje(response.message());
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<List<Subasta>> call, Throwable t) {
                                        mostrarMensaje(t.getMessage());
                                    }
                                });
                            }else {
                                if (spinnerCoop.getSelectedItemPosition() != 0 && spinnerProd.getSelectedItemPosition() == 0 && TextUtils.isEmpty(selectFecha.getText())) {
                                    Call<List<Subasta>> call = apiService.getSubastaCoop(Integer.toString(((Cooperativa)spinnerCoop.getSelectedItem()).getIdCooperativa()));
                                    call.enqueue(new Callback<List<Subasta>>() {
                                        @Override
                                        public void onResponse(Call<List<Subasta>> call, Response<List<Subasta>> response) {
                                            if (response.isSuccessful()) {
                                                apiAdapter.clear();
                                                apiAdapter.addAll(response.body());
                                                apiAdapter.notifyDataSetChanged();
                                            } else {
                                                apiAdapter.clear();
                                                apiAdapter.notifyDataSetChanged();
                                                mostrarMensaje(response.message());
                                            }
                                        }

                                        @Override
                                        public void onFailure(Call<List<Subasta>> call, Throwable t) {
                                            mostrarMensaje(t.getMessage());
                                        }
                                    });
                                }else {
                                    if (spinnerCoop.getSelectedItemPosition() != 0 && spinnerProd.getSelectedItemPosition() == 0 && !TextUtils.isEmpty(selectFecha.getText())) {
                                        Call<List<Subasta>> call = apiService.getSubastaFechaCoop(selectFecha.getText().toString(),Integer.toString(((Cooperativa)spinnerCoop.getSelectedItem()).getIdCooperativa()));
                                        call.enqueue(new Callback<List<Subasta>>() {
                                            @Override
                                            public void onResponse(Call<List<Subasta>> call, Response<List<Subasta>> response) {
                                                if (response.isSuccessful()) {
                                                    apiAdapter.clear();
                                                    apiAdapter.addAll(response.body());
                                                    apiAdapter.notifyDataSetChanged();
                                                } else {
                                                    apiAdapter.clear();
                                                    apiAdapter.notifyDataSetChanged();
                                                    mostrarMensaje(response.message());
                                                }
                                            }

                                            @Override
                                            public void onFailure(Call<List<Subasta>> call, Throwable t) {
                                                mostrarMensaje(t.getMessage());
                                            }
                                        });
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void limpiarDatos() {
        selectFecha.setText("");
        spinnerCoop.setSelection(0);
        spinnerProd.setSelection(0);
        apiAdapter.clear();
        apiAdapter.notifyDataSetChanged();
    }

    private void descargarSpinners() {
        Call<List<Cooperativa>> callcoop = apiService.getCooperativas();
        callcoop.enqueue(new Callback<List<Cooperativa>>() {
            @Override
            public void onResponse(Call<List<Cooperativa>> call, Response<List<Cooperativa>> response) {
                arrayListCooperativa.clear();
                arrayListCooperativa.add(new Cooperativa(0,"Todas las cooperativas"));
                arrayListCooperativa.addAll(response.body());
                adapterCooperativa.clear();
                adapterCooperativa.addAll(arrayListCooperativa);
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
                arrayListProducto.clear();
                arrayListProducto.add(new Producto(0,"Todos los productos"));
                arrayListProducto.addAll(response.body());
                adapterProducto.clear();
                adapterProducto.addAll(arrayListProducto);
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

    @Override
    public String getNombreCoop(int id) {
        return arrayListCooperativa.get(id).getNombreCooperativa();
    }

    @Override
    public String getNombreProd(int id) {
        return arrayListProducto.get(id).getNombreProducto();
    }
}
