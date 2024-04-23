package Indexacion_Visualizacion_Archivos;

import java.util.HashMap;
import java.util.Map;

public class Nodo {
    Map<Character, Nodo> hijos = new HashMap<>();
    boolean esFinDeRuta;
}