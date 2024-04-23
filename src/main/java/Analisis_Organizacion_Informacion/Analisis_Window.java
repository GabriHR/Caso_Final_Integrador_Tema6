package Analisis_Organizacion_Informacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;
import java.util.ArrayList;
import java.time.LocalDate;
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

    private void initUI() {
        setLayout(new BorderLayout());
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        // Crear una tabla para mostrar los datos
        Vector<String> columnNames = new Vector<>();
        columnNames.add("Cliente");
        columnNames.add("Producto");
        columnNames.add("Cantidad");
        columnNames.add("Fecha");

        Vector<Vector<Object>> data = new Vector<>();
        for (Venta venta : ordenacionBusqueda.getVentasOrdenadas()) {
            Vector<Object> row = new Vector<>();
            row.add(venta.getCliente());
            row.add(venta.getProducto());
            row.add(venta.getCantidad());
            row.add(venta.getFecha());
            data.add(row);
        }

        model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(500, 150));
        add(scrollPane, BorderLayout.CENTER);

        // Agregar botones para ordenar y filtrar los datos
        JPanel panel = new JPanel();

        JButton sortButton = new JButton("Ordenar");
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] options = {"Fecha", "Cantidad"};
                int response = JOptionPane.showOptionDialog(null, "¿Cómo quieres ordenar los datos?", "Ordenar", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

                if (response == 0) {
                    ordenacionBusqueda.getVentasOrdenadas().sort(Comparator.comparing(Venta::getFecha));
                } else if (response == 1) {
                    ordenacionBusqueda.getVentasOrdenadas().sort(Comparator.comparing(Venta::getCantidad));
                }
                updateTable();
            }
        });
        panel.add(sortButton);

        JButton filterButton = new JButton("Filtrar");
        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] options = {"Cliente", "Producto", "Fecha"};
                String response = (String) JOptionPane.showInputDialog(null, "¿Cómo quieres filtrar los datos?", "Filtrar", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                if (response != null) {
                    switch (response) {
                        case "Cliente":
                            String cliente = JOptionPane.showInputDialog("Introduce el nombre del cliente:");
                            if (cliente != null) {
                                List<Venta> ventas = analisisRegistros.filtrarRegistrosPorCliente(cliente);
                                updateTable(ventas);
                            }
                            break;
                        case "Producto":
                            String producto = JOptionPane.showInputDialog("Introduce el nombre del producto:");
                            if (producto != null) {
                                List<Venta> ventas = analisisRegistros.filtrarRegistrosPorProducto(producto);
                                updateTable(ventas);
                            }
                            break;
                        case "Fecha":
                            String fecha = JOptionPane.showInputDialog("Introduce la fecha (YYYY-MM-DD):");
                            if (fecha != null) {
                                List<Venta> ventas = analisisRegistros.filtrarRegistrosPorFecha(LocalDate.parse(fecha));
                                updateTable(ventas);
                            }
                            break;
                    }
                }
            }
        });
        panel.add(filterButton);

        JButton backButton = new JButton("Volver al menú principal");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra la ventana actual
            }
        });
        panel.add(backButton);
        filterButton.setPreferredSize(new Dimension(120, 30)); // Establecer un tamaño específico

        add(panel, BorderLayout.SOUTH);
    }

    private void updateTable() {
        model.setRowCount(0);
        for (Venta venta : ordenacionBusqueda.getVentasOrdenadas()) {
            Vector<Object> row = new Vector<>();
            row.add(venta.getCliente());
            row.add(venta.getProducto());
            row.add(venta.getCantidad());
            row.add(venta.getFecha());
            model.addRow(row);
        }
    }

    private void updateTable(List<Venta> ventas) {
        model.setRowCount(0);
        for (Venta venta : ventas) {
            Vector<Object> row = new Vector<>();
            row.add(venta.getCliente());
            row.add(venta.getProducto());
            row.add(venta.getCantidad());
            row.add(venta.getFecha());
            model.addRow(row);
        }
    }
}