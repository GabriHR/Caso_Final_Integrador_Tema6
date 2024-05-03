package Gestion_Datos_Dinamicos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gestion_Datos_Window extends JFrame {

    private JTextArea textArea;
    private ListaDatos listaDatos;
    private static JTextField realDataField;
    private JTextField integerPairField1;
    private JTextField integerPairField2;

    public Gestion_Datos_Window(ListaDatos listaDatos) {
        this.listaDatos = listaDatos;

        setLayout(new BorderLayout());
        textArea = new JTextArea();
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));

        realDataField = new JTextField();
        integerPairField1 = new JTextField();
        integerPairField2 = new JTextField();

        inputPanel.add(new JLabel("Dato real:"));
        inputPanel.add(realDataField);
        inputPanel.add(new JLabel("Primer número del par:"));
        inputPanel.add(integerPairField1);
        inputPanel.add(new JLabel("Segundo número del par:"));
        inputPanel.add(integerPairField2);

        add(inputPanel, BorderLayout.NORTH);

        JButton addButton = new JButton("Agregar datos");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double realData = Double.parseDouble(realDataField.getText());
                int integer1 = Integer.parseInt(integerPairField1.getText());
                int integer2 = Integer.parseInt(integerPairField2.getText());

                listaDatos.addDatoReal(realData);
                listaDatos.addPareja(new Pareja(integer1, integer2));

                updateTextArea();
            }
        });

        add(addButton, BorderLayout.SOUTH);

        updateTextArea();

        setSize(400, 300); // Ajusta el tamaño de la ventana a tus necesidades
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        setVisible(true);
    }

    private void updateTextArea() {
        StringBuilder sb = new StringBuilder();

        sb.append("Datos reales:\n");
        for (Double datoReal : listaDatos.getDatosReales()) {
            sb.append(datoReal).append("\n");
        }

        sb.append("\nPares de números enteros:\n");
        for (Pareja pareja : listaDatos.getParejas()) {
            sb.append("(").append(pareja.getPrimero()).append(", ").append(pareja.getSegundo()).append(")\n");
        }

        textArea.setText(sb.toString());
    }

    public static JTextField getRealDataField() {
        return realDataField;
    }
}