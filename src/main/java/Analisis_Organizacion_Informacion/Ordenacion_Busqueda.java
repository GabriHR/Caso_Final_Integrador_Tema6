package Analisis_Organizacion_Informacion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ordenacion_Busqueda {
    private List<Venta> ventas;
    private List<Venta> originalVentas;

    public Ordenacion_Busqueda() {
        ventas = new ArrayList<>();
        originalVentas = new ArrayList<>();
    }

    public void agregarVenta(Venta venta) {
        ventas.add(venta);
        originalVentas.add(venta);
        ventas.sort(Comparator.comparing(Venta::getFecha));
    }

    public List<Venta> getVentasOrdenadas() {
        return ventas;
    }

    public void setVentasOrdenadas(List<Venta> ventasOrdenadas) {
        this.ventas = ventasOrdenadas;
    }

    public void resetFilters() {
        this.ventas = new ArrayList<>(originalVentas);
    }
}