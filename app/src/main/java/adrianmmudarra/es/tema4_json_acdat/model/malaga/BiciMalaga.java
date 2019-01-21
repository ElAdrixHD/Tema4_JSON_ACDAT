package adrianmmudarra.es.tema4_json_acdat.model.malaga;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BiciMalaga {

    @SerializedName("direccion")
    @Expose
    private String direccion;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("id_estado")
    @Expose
    private String idEstado;
    @SerializedName("id_externo")
    @Expose
    private String idExterno;
    @SerializedName("latitud")
    @Expose
    private String latitud;
    @SerializedName("longitud")
    @Expose
    private String longitud;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("nombreCiudad")
    @Expose
    private String nombreCiudad;
    @SerializedName("nombre_estado")
    @Expose
    private String nombreEstado;
    @SerializedName("num_derbis")
    @Expose
    private String numDerbis;
    @SerializedName("num_libres")
    @Expose
    private String numLibres;
    @SerializedName("num_ocupadas")
    @Expose
    private String numOcupadas;

    public BiciMalaga(String direccion, String id, String idEstado, String idExterno, String latitud, String longitud, String nombre, String nombreCiudad, String nombreEstado, String numDerbis, String numLibres, String numOcupadas) {
        super();
        this.direccion = direccion;
        this.id = id;
        this.idEstado = idEstado;
        this.idExterno = idExterno;
        this.latitud = latitud;
        this.longitud = longitud;
        this.nombre = nombre;
        this.nombreCiudad = nombreCiudad;
        this.nombreEstado = nombreEstado;
        this.numDerbis = numDerbis;
        this.numLibres = numLibres;
        this.numOcupadas = numOcupadas;
    }


    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(String idEstado) {
        this.idEstado = idEstado;
    }

    public String getIdExterno() {
        return idExterno;
    }

    public void setIdExterno(String idExterno) {
        this.idExterno = idExterno;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public String getNumDerbis() {
        return numDerbis;
    }

    public void setNumDerbis(String numDerbis) {
        this.numDerbis = numDerbis;
    }

    public String getNumLibres() {
        return numLibres;
    }

    public void setNumLibres(String numLibres) {
        this.numLibres = numLibres;
    }

    public String getNumOcupadas() {
        return numOcupadas;
    }

    public void setNumOcupadas(String numOcupadas) {
        this.numOcupadas = numOcupadas;
    }

}