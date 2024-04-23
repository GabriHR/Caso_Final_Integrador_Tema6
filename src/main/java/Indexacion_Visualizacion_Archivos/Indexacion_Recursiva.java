package Indexacion_Visualizacion_Archivos;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Indexacion_Recursiva {
    private Nodo raiz;

    public Indexacion_Recursiva() {
        raiz = new Nodo();
    }

    public void insertar(String ruta) {
        Nodo nodoActual = raiz;
        for (char c : ruta.toCharArray()) {
            nodoActual.hijos.putIfAbsent(c, new Nodo());
            nodoActual = nodoActual.hijos.get(c);
        }
        nodoActual.esFinDeRuta = true;
    }

    public boolean buscar(String ruta) {
        Nodo nodoActual = raiz;
        for (char c : ruta.toCharArray()) {
            Nodo nodo = nodoActual.hijos.get(c);
            if (nodo == null) {
                return false;
            }
            nodoActual = nodo;
        }
        return nodoActual.esFinDeRuta;
    }

    public void indexarDirectorio(String rutaDirectorio) {
        File directorio = new File(rutaDirectorio);
        File[] archivos = directorio.listFiles();
        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isDirectory()) {
                    indexarDirectorio(archivo.getPath());
                } else {
                    insertar(archivo.getPath());
                }
            }
        }
    }

    public List<String> obtenerRutasIndexadas() {
        List<String> rutas = new ArrayList<>();
        obtenerRutasIndexadas(raiz, "", rutas);
        return rutas;
    }

    private void obtenerRutasIndexadas(Nodo nodo, String ruta, List<String> rutas) {
        for (Map.Entry<Character, Nodo> entry : nodo.hijos.entrySet()) {
            if (entry.getValue().esFinDeRuta) {
                rutas.add(ruta + entry.getKey());
            }
            obtenerRutasIndexadas(entry.getValue(), ruta + entry.getKey(), rutas);
        }
    }

}