package Analisis_Organizacion_Informacion;

import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Analisis_Window extends JFrame {
    private Ordenacion_Busqueda ordenacionBusqueda;
    private Analisis_Registros analisisRegistros;
    private JTable table;
    private DefaultTableModel model;
    private List<Venta> datosOriginales;

    public Analisis_Window(Ordenacion_Busqueda ordenacionBusqueda, Analisis_Registros analisisRegistros) {
        this.ordenacionBusqueda = ordenacionBusqueda;
        this.analisisRegistros = analisisRegistros;
        this.datosOriginales = new ArrayList<>(ordenacionBusqueda.getVentasOrdenadas());

        initUI();
    }

}