package Mapas_Asociacion_Datos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

public class Recuperacion_Eficiente_Window extends JFrame {
    private HashMap<Integer, String> idMap;
    private DefaultListModel<String> listModel;
    private JTextField idField;
    private JTextField valueField;

    public Recuperacion_Eficiente_Window() {
        idMap = new HashMap<>();
        listModel = new DefaultListModel<>();

        setLayout(new BorderLayout());

        JList<String> idList = new JList<>(listModel);
        add(new JScrollPane(idList), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        idField = new JTextField(10); // Campo de texto para la ID
        valueField = new JTextField(10); // Campo de texto para el valor
        buttonPanel.add(new JLabel("ID:"));
        buttonPanel.add(idField);
        buttonPanel.add(new JLabel("Valor:"));
        buttonPanel.add(valueField);

        JButton agregarButton = new JButton("Agregar ID y Valor");
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    String valor = valueField.getText();

                    idMap.put(id, valor);
                    listModel.addElement("ID: " + id + ", Valor: " + valor);

                    idField.setText("");
                    valueField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "La ID solo admite números.");
                }
            }
        });
        buttonPanel.add(agregarButton);

        JButton generarIdButton = new JButton("Generar ID");
        generarIdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = new Random().nextInt(100000);
                String valor = UUID.randomUUID().toString().substring(0, 8);

                idMap.put(id, valor);
                listModel.addElement("ID: " + id + ", Valor: " + valor);
            }
        });
        buttonPanel.add(generarIdButton);

        JButton buscarIdButton = new JButton("Buscar ID");
        buscarIdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idString = JOptionPane.showInputDialog("Introduce una ID:");
                if (idString != null) {
                    try {
                        int id = Integer.parseInt(idString);

                        if (idMap.containsKey(id)) {
                            String valor = idMap.get(id);
                            JOptionPane.showMessageDialog(null, "Valor: " + valor);
                        } else {
                            JOptionPane.showMessageDialog(null, "No se ha definido dicha ID.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "La ID debe ser un número.");
                    }
                }
            }
        });
        buttonPanel.add(buscarIdButton);

        JButton volverButton = new JButton("Menu principal");
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra la ventana actual
            }
        });
        buttonPanel.add(volverButton);

        add(buttonPanel, BorderLayout.SOUTH);

        setSize(800, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}