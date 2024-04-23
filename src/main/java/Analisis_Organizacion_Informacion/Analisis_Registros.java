package Analisis_Organizacion_Informacion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;

public class Analisis_Registros {
    private List<Venta> registros;

    public Analisis_Registros() {
        registros = new ArrayList<>();
    }

    public void agregarRegistro(Venta venta) {
        registros.add(venta);
    }

    public List<Venta> filtrarRegistrosPorCliente(String cliente) {
        List<Venta> ventasFiltradas = new ArrayList<>();
        for (Venta venta : registros) {
            if (venta.getCliente().equalsIgnoreCase(cliente)) {
                ventasFiltradas.add(venta);
            }
        }
        return ventasFiltradas;
    }

    public List<Venta> filtrarRegistrosPorProducto(String producto) {
        return registros.stream()
                .filter(venta -> venta.getProducto().equals(producto))
                .collect(Collectors.toList());
    }

    public List<Venta> filtrarRegistrosPorMes(int mes) {
        return registros.stream()
                .filter(venta -> venta.getFecha().getMonthValue() == mes)
                .collect(Collectors.toList());
    }

    public List<Venta> filtrarRegistrosPorAno(int ano) {
        return registros.stream()
                .filter(venta -> venta.getFecha().getYear() == ano)
                .collect(Collectors.toList());
    }

    public List<Venta> filtrarRegistrosPorFecha(LocalDate fecha) {
        List<Venta> ventasFiltradas = new ArrayList<>();
        for (Venta venta : registros) {
            if (venta.getFecha().equals(fecha)) {
                ventasFiltradas.add(venta);
            }
        }
        return ventasFiltradas;
    }

}