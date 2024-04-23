package Mapas_Asociacion_Datos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gestion_Relaciones_Window extends JFrame {
    private Gestion_Relaciones relaciones;
    private Recuperacion_Eficiente recuperacion;
    private JTextArea textArea;

    public Gestion_Relaciones_Window(Gestion_Relaciones relaciones, Recuperacion_Eficiente recuperacion) {
        this.relaciones = relaciones;
        this.recuperacion = recuperacion;

        setLayout(new BorderLayout());

        textArea = new JTextArea();
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JButton backButton = new JButton("Volver al menú principal");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra la ventana actual
            }
        });
        add(backButton, BorderLayout.SOUTH);

        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        setVisible(true);
    }
}