package Analisis_Organizacion_Informacion;

import java.time.LocalDate;

public class Venta {
    private String cliente;
    private String producto;
    private double cantidad;
    private LocalDate fecha;

    public Venta(String cliente, String producto, double cantidad, LocalDate fecha) {
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

}