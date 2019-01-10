package adrianmmudarra.es.tema4_json_acdat.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import adrianmmudarra.es.tema4_json_acdat.R;

public class MeteoActivity extends AppCompatActivity {
//https://stackoverflow.com/questions/3371326/java-date-from-unix-timestamp
    private static final String URL = "http://api.openweathermap.org/data/2.5/weather?q=madrid,es&units=metric&APPID=8c8452ba700cbab5cd5c81d6cb3dd338";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meteo);
    }
}
