package Gestion_Datos_Dinamicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class ListaDatos extends Observable {
    private List<Double> datosReales;
    private List<Pareja> parejas;

    public ListaDatos() {
        datosReales = new ArrayList<>();
        parejas = new ArrayList<>();
    }

}