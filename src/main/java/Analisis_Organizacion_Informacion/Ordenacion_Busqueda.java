package Analisis_Organizacion_Informacion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ordenacion_Busqueda {
    private List<Venta> ventas;

    public Ordenacion_Busqueda() {
        ventas = new ArrayList<>();
    }

    public void agregarVenta(Venta venta) {
        ventas.add(venta);
        ventas.sort(Comparator.comparing(Venta::getFecha));
    }
}