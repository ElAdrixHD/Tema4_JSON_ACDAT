package adrianmmudarra.es.tema4_json_acdat.ui;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.security.Key;

import adrianmmudarra.es.tema4_json_acdat.R;
import adrianmmudarra.es.tema4_json_acdat.adapter.ApiAdapter;
import adrianmmudarra.es.tema4_json_acdat.model.bizi.Result;
import adrianmmudarra.es.tema4_json_acdat.network.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EstacionActivity extends AppCompatActivity implements OnMapReadyCallback {

    public static final String KEY = "STATION";
    String id;
    TextView tv_nombre, tv_bicis, tv_anclajes;
    ApiService apiService;
    GoogleMap gMap;
    Result result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estacion);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.g_map);
        mapFragment.getMapAsync(this);
        inicializacion();
    }

    private void inicializacion() {
        Intent i = getIntent();
        id = i.getStringExtra(KEY);
        tv_nombre = findViewById(R.id.tv_estacion_nombre);
        tv_bicis = findViewById(R.id.tv_estacion_disponibles);
        tv_anclajes= findViewById(R.id.tv_estacion_anclajes);


        apiService = ApiAdapter.getInstanceBizi();

        descargarEstacion();
    }

    private void descargarEstacion() {
        Call<Result> call = apiService.getBizisporId(id);
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                result = response.body();
                tv_nombre.setText(result.getTitle());
                tv_bicis.setText(Integer.toString(result.getBicisDisponibles()));
                tv_anclajes.setText(Integer.toString(result.getAnclajesDisponibles()));

                LatLng zona = new LatLng(result.getGeometry().getCoordinates().get(1), result.getGeometry().getCoordinates().get(0));
                gMap.addMarker(new MarkerOptions().position(zona).title(result.getTitle()));
                gMap.moveCamera(CameraUpdateFactory.newLatLng(zona));
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                mostrarMensaje(t.getMessage());
            }
        });


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;
        gMap.setMinZoomPreference(18);
        gMap.setIndoorEnabled(true);

        UiSettings uiSettings = gMap.getUiSettings();
        uiSettings.setIndoorLevelPickerEnabled(true);
        uiSettings.setMyLocationButtonEnabled(true);
        uiSettings.setMapToolbarEnabled(true);
        uiSettings.setCompassEnabled(true);
        uiSettings.setZoomControlsEnabled(true);
    }

    private void mostrarMensaje(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }
}
