package adrianmmudarra.es.tema4_json_acdat.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import adrianmmudarra.es.tema4_json_acdat.R;

public class MenuActivity extends AppCompatActivity {

    Button ej1, ej2, ej3, ej4, ej5, ej6, ejvol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        inicializar();
    }

    private void inicializar() {
        ej1 = findViewById(R.id.btn_menu_ej1);
        ej2 = findViewById(R.id.btn_menu_ej2);
        ej3 = findViewById(R.id.btn_menu_ej3);
        ej4 = findViewById(R.id.btn_menu_ej4);
        ej5 = findViewById(R.id.btn_menu_ej5);
        ej6 = findViewById(R.id.btn_menu_ej6);
        ejvol = findViewById(R.id.btn_menu_ejvolun);

        ej1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, MeteoActivity.class));
            }
        });
        ej2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, ConversorActivity.class));
            }
        });
        ej3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, BiziActivity.class));
            }
        });
        ej4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, RssActivity.class));
            }
        });

        ejvol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, MalagaActivity.class));
            }
        });
    }
}
