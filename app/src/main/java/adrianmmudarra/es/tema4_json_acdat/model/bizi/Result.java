package adrianmmudarra.es.tema4_json_acdat.model.bizi;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Result implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("about")
    @Expose
    private String about;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("estado")
    @Expose
    private String estado;
    @SerializedName("bicisDisponibles")
    @Expose
    private Integer bicisDisponibles;
    @SerializedName("anclajesDisponibles")
    @Expose
    private Integer anclajesDisponibles;
    @SerializedName("geometry")
    @Expose
    private Geometry geometry;
    @SerializedName("lastUpdated")
    @Expose
    private String lastUpdated;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("icon")
    @Expose
    private String icon;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getBicisDisponibles() {
        return bicisDisponibles;
    }

    public void setBicisDisponibles(Integer bicisDisponibles) {
        this.bicisDisponibles = bicisDisponibles;
    }

    public Integer getAnclajesDisponibles() {
        return anclajesDisponibles;
    }

    public void setAnclajesDisponibles(Integer anclajesDisponibles) {
        this.anclajesDisponibles = anclajesDisponibles;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @NonNull
    @Override
    public String toString() {
        return getTitle();
    }
}
