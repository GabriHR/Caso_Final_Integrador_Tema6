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

    }
}