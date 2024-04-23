package Mapas_Asociacion_Datos;

import java.util.HashMap;
import java.util.Map;

public class Recuperacion_Eficiente {
    private Map<Integer, Character> map;

    public Recuperacion_Eficiente() {
        map = new HashMap<>();
    }

    public void agregarAsociacion(int numero, char letra) {
        map.put(numero, letra);
    }

    public void eliminarAsociacion(int numero) {
        map.remove(numero);
    }
    public char obtenerLetra(int numero) {
        Character letra = map.get(numero);
        if (letra != null) {
            return letra;
        } else {
            // return a default value, such as a space or a special character
            return ' ';
        }
    }
}