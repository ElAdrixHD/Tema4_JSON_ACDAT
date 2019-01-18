package adrianmmudarra.es.tema4_json_acdat.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import adrianmmudarra.es.tema4_json_acdat.network.ApiService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiAdapterBizi {
    private static ApiService API_SERVICE;
    private static final String URL_BIZI = "https://www.zaragoza.es/";

    public static synchronized ApiService getInstance() {
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
                    .baseUrl(URL_BIZI)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(okHttpClient)
                    .build();

            API_SERVICE = retrofit.create(ApiService.class);
        }
        return  API_SERVICE;
    }
}
