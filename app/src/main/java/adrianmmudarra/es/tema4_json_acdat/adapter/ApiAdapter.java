package adrianmmudarra.es.tema4_json_acdat.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import adrianmmudarra.es.tema4_json_acdat.network.ApiService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiAdapter {
    private static ApiService API_SERVICE;

    public static final String URL_TIEMPO = "https://api.openweathermap.org/";
    private static final String URL_MONEDA = "https://openexchangerates.org/";

    public static synchronized ApiService getInstanceTiempo() {

        if (API_SERVICE == null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(5, TimeUnit.SECONDS)
                    .build();

            Gson gson = new GsonBuilder()
                    .setDateFormat("dd-MM-yyyy")
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(URL_TIEMPO)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(okHttpClient)
                    .build();

            API_SERVICE = retrofit.create(ApiService.class);
        }
        return  API_SERVICE;
    }

    public static synchronized ApiService getInstanceMoneda() {

        if (API_SERVICE == null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(5, TimeUnit.SECONDS)
                    .build();

            Gson gson = new GsonBuilder()
                    .setDateFormat("dd-MM-yyyy")
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(URL_MONEDA)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(okHttpClient)
                    .build();

            API_SERVICE = retrofit.create(ApiService.class);
        }
        return  API_SERVICE;
    }
}
