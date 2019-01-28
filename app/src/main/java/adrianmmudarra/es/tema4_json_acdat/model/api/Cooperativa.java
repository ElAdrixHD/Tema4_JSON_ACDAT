package adrianmmudarra.es.tema4_json_acdat.model.api;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cooperativa {

    @SerializedName("id_cooperativa")
    @Expose
    private Integer idCooperativa;
    @SerializedName("nombre_cooperativa")
    @Expose
    private String nombreCooperativa;

    public Integer getIdCooperativa() {
        return idCooperativa;
    }

    public void setIdCooperativa(Integer idCooperativa) {
        this.idCooperativa = idCooperativa;
    }

    public String getNombreCooperativa() {
        return nombreCooperativa;
    }

    public void setNombreCooperativa(String nombreCooperativa) {
        this.nombreCooperativa = nombreCooperativa;
    }

    @NonNull
    @Override
    public String toString() {
        return getNombreCooperativa();
    }
}