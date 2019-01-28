package adrianmmudarra.es.tema4_json_acdat.model.api;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Producto {

    @SerializedName("id_producto")
    @Expose
    private Integer idProducto;
    @SerializedName("nombre_producto")
    @Expose
    private String nombreProducto;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    @NonNull
    @Override
    public String toString() {
        return getNombreProducto();
    }
}