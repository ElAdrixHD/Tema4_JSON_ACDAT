package adrianmmudarra.es.tema4_json_acdat.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import adrianmmudarra.es.tema4_json_acdat.R;

public class RssActivity extends AppCompatActivity {

    /*
    https://www.abc.es/rss/feeds/abc_ultima.xml
    https://www.europapress.es/rss/rss.aspx
    https://www.20minutos.es/rss/
    http://api2.rtve.es/rss/temas_noticias.xml
    http://ep00.epimg.net/rss/tags/ultimas_noticias.xml
    http://feeds2.feedburner.com/libertaddigital/portada
    https://www.lavozdigital.es/rss/feeds/lavozdigital_ultima.xml
    https://rss.elconfidencial.com/espana/
    https://e00-elmundo.uecdn.es/elmundo/rss/portada.xml
    https://e00-expansion.uecdn.es/rss/portada.xml
    https://as.com/rss/tags/ultimas_noticias.xml
    https://www.elperiodico.com/es/rss/internacional/rss.xml
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rss);
    }
}
