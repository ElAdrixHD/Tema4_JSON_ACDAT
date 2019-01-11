package adrianmmudarra.es.tema4_json_acdat.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import adrianmmudarra.es.tema4_json_acdat.model.Ciudad;
import adrianmmudarra.es.tema4_json_acdat.model.Coord;

public class Analysis {
    public static ArrayList<Ciudad> ciudadesAnalyze(JSONArray response) throws JSONException {
        JSONObject objectCiudad;
        JSONObject objectCoord;
        Ciudad ciudad;
        Coord coord;
        ArrayList<Ciudad> ciudades = new ArrayList<>();
        for(int i = 0; i< response.length();i++){
            objectCiudad = response.getJSONObject(i);
            ciudad = new Ciudad();
            ciudad.setId(objectCiudad.getInt("id"));
            ciudad.setName(objectCiudad.getString("name"));
            ciudad.setCountry(objectCiudad.getString("country"));
            objectCoord = objectCiudad.getJSONObject("coord");
            coord = new Coord();
            coord.setLon(objectCoord.getDouble("lon"));
            coord.setLat(objectCoord.getDouble("lat"));
            ciudad.setCoord(coord);
            ciudades.add(ciudad);
        }
        return ciudades;
    }
}
