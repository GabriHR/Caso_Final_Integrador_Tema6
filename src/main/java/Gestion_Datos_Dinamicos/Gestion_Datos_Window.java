package Gestion_Datos_Dinamicos;

import javax.swing.*;
import java.awt.*;

public class Gestion_Datos_Window extends JFrame {

    private JTextArea textArea;
    private ListaDatos listaDatos;
    private JTextField realDataField;
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

    }
}