package adrianmmudarra.es.tema4_json_acdat.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.security.Key;

import adrianmmudarra.es.tema4_json_acdat.R;
import adrianmmudarra.es.tema4_json_acdat.model.bizi.Result;

public class EstacionActivity extends AppCompatActivity {

    public static final String KEY = "STATION";
    Result result;
    TextView tv_nombre, tv_bicis, tv_anclajes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estacion);
        inicializacion();
    }

    private void inicializacion() {
        Intent i = getIntent();
        Bundle b = i.getBundleExtra(KEY);
        result = (Result)b.getSerializable(KEY);
        tv_nombre = findViewById(R.id.tv_estacion_nombre);
        tv_bicis = findViewById(R.id.tv_estacion_disponibles);
        tv_anclajes= findViewById(R.id.tv_estacion_anclajes);

        tv_nombre.setText(result.getTitle());
        tv_bicis.setText(result.getBicisDisponibles());
        tv_anclajes.setText(result.getAnclajesDisponibles());
    }
}
