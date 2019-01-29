package adrianmmudarra.es.tema4_json_acdat.network;

import java.util.ArrayList;
import java.util.List;

import adrianmmudarra.es.tema4_json_acdat.model.api.Cooperativa;
import adrianmmudarra.es.tema4_json_acdat.model.api.Producto;
import adrianmmudarra.es.tema4_json_acdat.model.api.Subasta;
import adrianmmudarra.es.tema4_json_acdat.model.bizi.Bizi;
import adrianmmudarra.es.tema4_json_acdat.model.bizi.Result;
import adrianmmudarra.es.tema4_json_acdat.model.conversor.Conversor;
import adrianmmudarra.es.tema4_json_acdat.model.conversor.Monedas;
import adrianmmudarra.es.tema4_json_acdat.model.malaga.BiciMalaga;
import adrianmmudarra.es.tema4_json_acdat.model.metereologia.Tiempo;
import adrianmmudarra.es.tema4_json_acdat.model.rss.Feed;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("data/2.5/weather")
    Call<Tiempo> getTiempo(@Query("id") String id, @Query("units") String units, @Query("appid") String appid);

    @GET("api/latest.json")
    Call<Conversor> getConversion(@Query("app_id") String appid);

    @GET("api/currencies.json")
    Call<Monedas> getMonedas(@Query("app_id") String appid);

    @GET("sede/servicio/urbanismo-infraestructuras/estacion-bicicleta.json")
    Call<Bizi> getBizis();

    @GET("sede/servicio/urbanismo-infraestructuras/estacion-bicicleta/{id}.json")
    Call<Result> getBizisporId(@Path("id") String id);

    @GET("uploads/bicis.json")
    Call<List<BiciMalaga>> getBicisMalaga();

    @GET("{url}")
    Call<Feed> getRss(@Path("url") String url);

    @GET("api/cooperativa")
    Call<List<Cooperativa>>getCooperativas();

    @GET("api/producto")
    Call<List<Producto>>getProductos();

    @GET("api/subasta")
    Call<List<Subasta>>getTodaSubasta();

    @GET("api/subasta/cooperativa/{id}")
    Call<List<Subasta>>getSubastaCoop(@Path("id")String id);

    @GET("api/subasta/fecha/{id}")
    Call<List<Subasta>>getSubastaFecha(@Path("id")String id);

    @GET("api/subasta/producto/{id}")
    Call<List<Subasta>>getSubastaProd(@Path("id")String id);

    @GET("api/subasta/fecha/{fecha}/cooperativa/{id}")
    Call<List<Subasta>>getSubastaFechaCoop(@Path("fecha") String fecha, @Path("id")String id);

    @GET("api/subasta/fecha/{fecha}/producto/{id}")
    Call<List<Subasta>>getSubastaFechaProd(@Path("fecha") String fecha, @Path("id")String id);

    @GET("api/subasta/fecha/{fecha}/cooperativa/{idC}/producto/{idP}")
    Call<List<Subasta>>getSubastaFechaCoopProd(@Path("fecha") String fecha, @Path("idC")String idC, @Path("idP")String idP);

    @GET("api/subasta/cooperativa/{idC}/producto/{idP}")
    Call<List<Subasta>>getSubastaCoopProd(@Path("idC") String idC, @Path("idP")String idP);

}
