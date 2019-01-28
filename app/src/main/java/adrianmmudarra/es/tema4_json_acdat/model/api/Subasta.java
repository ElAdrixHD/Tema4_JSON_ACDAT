package adrianmmudarra.es.tema4_json_acdat.model.api;

import android.support.annotation.NonNull;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Subasta {

    @SerializedName("fecha_subasta")
    @Expose
    private String fechaSubasta;
    @SerializedName("cooperativa")
    @Expose
    private Integer cooperativa;
    @SerializedName("producto")
    @Expose
    private Integer producto;
    @SerializedName("precios")
    @Expose
    private List<Double> precios = null;

    public String getFechaSubasta() {
        return fechaSubasta;
    }

    public void setFechaSubasta(String fechaSubasta) {
        this.fechaSubasta = fechaSubasta;
    }

    public Integer getCooperativa() {
        return cooperativa;
    }

    public void setCooperativa(Integer cooperativa) {
        this.cooperativa = cooperativa;
    }

    public Integer getProducto() {
        return producto;
    }

    public void setProducto(Integer producto) {
        this.producto = producto;
    }

    public List<Double> getPrecios() {
        return precios;
    }

    public void setPrecios(List<Double> precios) {
        this.precios = precios;
    }

    @NonNull
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getPrecios().get(0));
        for (int i = 1; i < precios.size(); i++){
            stringBuilder.append(", ");
            stringBuilder.append(precios.get(i));
        }
        return stringBuilder.toString();
    }
}
