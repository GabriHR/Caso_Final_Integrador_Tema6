package Mapas_Asociacion_Datos;

import java.util.HashMap;
import java.util.Map;

public class Gestion_Relaciones {
    private Map<Integer, String> relaciones;

    public Gestion_Relaciones() {
        relaciones = new HashMap<>();
    }

    public void agregarRelacion(int numero, String texto) {
        relaciones.put(numero, texto);
    }
}