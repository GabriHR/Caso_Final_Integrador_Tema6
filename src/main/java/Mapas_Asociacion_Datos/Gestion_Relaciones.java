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

    public void eliminarRelacion(int index) {
        // Assuming that 'relaciones' is a List or an array
        if (index >= 0 && index < relaciones.size()) {
            relaciones.remove(index);
        }
    }
}