package adrianmmudarra.es.tema4_json_acdat.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.security.Key;

import adrianmmudarra.es.tema4_json_acdat.R;

public class MapaMalagaActivity extends AppCompatActivity implements OnMapReadyCallback {

    public static final String KEY = "MALAGA";
    public static final String KEY2 = "MALAGA2";

    String lat;
    String lon;
    GoogleMap gMap;
    float latF;
    float lonF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_malaga);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.g_map2);
        mapFragment.getMapAsync(this);
        inicializacion();
    }

    private void inicializacion() {
        Intent i = getIntent();
        lat = i.getStringExtra(KEY);
        lon = i.getStringExtra(KEY2);
        latF = Float.parseFloat(lat);
        lonF = Float.parseFloat(lon);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;
        gMap.setMinZoomPreference(50);
        gMap.setIndoorEnabled(true);

        LatLng zona = new LatLng(lonF,latF);
        gMap.addMarker(new MarkerOptions().position(zona).title("Malaga Bici"));
        gMap.moveCamera(CameraUpdateFactory.newLatLng(zona));

        UiSettings uiSettings = gMap.getUiSettings();
        uiSettings.setIndoorLevelPickerEnabled(true);
        uiSettings.setMyLocationButtonEnabled(true);
        uiSettings.setMapToolbarEnabled(true);
        uiSettings.setCompassEnabled(true);
        uiSettings.setZoomControlsEnabled(true);
    }
}
