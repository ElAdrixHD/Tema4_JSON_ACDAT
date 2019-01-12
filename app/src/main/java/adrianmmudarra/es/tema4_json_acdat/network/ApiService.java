package adrianmmudarra.es.tema4_json_acdat.network;

import adrianmmudarra.es.tema4_json_acdat.model.metereologia.Tiempo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("data/2.5/weather")
    Call<Tiempo> getTiempo(@Query("id") String id, @Query("units") String units, @Query("appid") String appid);
}
