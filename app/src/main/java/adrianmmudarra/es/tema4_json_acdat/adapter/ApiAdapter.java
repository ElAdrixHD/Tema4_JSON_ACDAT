package adrianmmudarra.es.tema4_json_acdat.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;

import java.util.concurrent.TimeUnit;

import adrianmmudarra.es.tema4_json_acdat.network.ApiService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class ApiAdapter {
    private static ApiService API_SERVICE_BIZI;
    private static ApiService API_SERVICE_MONEDA;
    private static ApiService API_SERVICE_TIEMPO;
    private static ApiService API_SERVICE_MALAGA;
    private static ApiService API_SERVICE_RSS;
    private static final String URL_MALAGA = "http://adrianm.alumno.mobi/";
    private static final String URL_BIZI = "https://www.zaragoza.es/";
    private static final String URL_MONEDA = "https://openexchangerates.org/";
    private static final String URL_TIEMPO = "https://api.openweathermap.org/";

    public static synchronized ApiService getInstanceBizi() {
        if (API_SERVICE_BIZI == null) {
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

            API_SERVICE_BIZI = retrofit.create(ApiService.class);
        }
        return  API_SERVICE_BIZI;
    }

    public static synchronized ApiService getInstanceMoneda() {
        if (API_SERVICE_MONEDA == null) {
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

            API_SERVICE_MONEDA = retrofit.create(ApiService.class);
        }
        return  API_SERVICE_MONEDA;
    }

    public static synchronized ApiService getInstanceTiempo() {

        if (API_SERVICE_TIEMPO == null) {
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

            API_SERVICE_TIEMPO = retrofit.create(ApiService.class);
        }
        return  API_SERVICE_TIEMPO;
    }

    public static synchronized ApiService getInstanceMalaga() {
        if (API_SERVICE_MALAGA == null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(5, TimeUnit.SECONDS)
                    .build();

            Gson gson = new GsonBuilder()
                    .setDateFormat("dd-MM-yyyy")
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(URL_MALAGA)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(okHttpClient)
                    .build();

            API_SERVICE_MALAGA = retrofit.create(ApiService.class);
        }
        return  API_SERVICE_MALAGA;
    }

    public static synchronized ApiService getInstanceRss(String baseurl) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseurl)
                //.addConverterFactory(SimpleXmlConverterFactory.createNonStrict(new Persister(new AnnotationStrategy())))
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .client(okHttpClient)
                .build();

        API_SERVICE_RSS = retrofit.create(ApiService.class);
        return  API_SERVICE_RSS;
    }
}
