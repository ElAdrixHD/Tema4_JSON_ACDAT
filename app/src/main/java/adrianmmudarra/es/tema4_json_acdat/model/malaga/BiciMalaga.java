package adrianmmudarra.es.tema4_json_acdat.model.malaga;

public class BiciMalaga {
    private String id;
    private String nombre;
    private String nombreCiudad;
    private String direccion;
    private String id_estado;
    private String nombre_estado;
    private String num_derbis;
    private String num_libres;
    private String num_ocupadas;
    private String latitud;
    private String longitud;
    private String id_externo;

    public BiciMalaga(String id, String nombre, String nombreCiudad, String direccion, String id_estado, String nombre_estado, String num_derbis, String num_libres, String num_ocupadas, String latitud, String longitud, String id_externo) {
        this.id = id;
        this.nombre = nombre;
        this.nombreCiudad = nombreCiudad;
        this.direccion = direccion;
        this.id_estado = id_estado;
        this.nombre_estado = nombre_estado;
        this.num_derbis = num_derbis;
        this.num_libres = num_libres;
        this.num_ocupadas = num_ocupadas;
        this.latitud = latitud;
        this.longitud = longitud;
        this.id_externo = id_externo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getId_estado() {
        return id_estado;
    }

    public void setId_estado(String id_estado) {
        this.id_estado = id_estado;
    }

    public String getNombre_estado() {
        return nombre_estado;
    }

    public void setNombre_estado(String nombre_estado) {
        this.nombre_estado = nombre_estado;
    }

    public String getNum_derbis() {
        return num_derbis;
    }

    public void setNum_derbis(String num_derbis) {
        this.num_derbis = num_derbis;
    }

    public String getNum_libres() {
        return num_libres;
    }

    public void setNum_libres(String num_libres) {
        this.num_libres = num_libres;
    }

    public String getNum_ocupadas() {
        return num_ocupadas;
    }

    public void setNum_ocupadas(String num_ocupadas) {
        this.num_ocupadas = num_ocupadas;
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

    public String getId_externo() {
        return id_externo;
    }

    public void setId_externo(String id_externo) {
        this.id_externo = id_externo;
    }

}
