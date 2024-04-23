package Indexacion_Visualizacion_Archivos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Indexacion_Recursiva_Window extends JFrame {
    private Indexacion_Recursiva indexacion;
    private JTextArea textArea;

    public Indexacion_Recursiva_Window() {
        setTitle("Indexación Recursiva");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        indexacion = new Indexacion_Recursiva();
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        JButton button = new JButton("Iniciar Indexación Recursiva");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indexacion.indexarDirectorio("/ruta/a/tu/directorio"); // Reemplaza esto con la ruta a tu directorio
                mostrarRutasIndexadas();
            }
        });
        add(button, BorderLayout.SOUTH);
    }

    private void mostrarRutasIndexadas() {
        textArea.setText("");
        for (String ruta : indexacion.obtenerRutasIndexadas()) {
            textArea.append(ruta + "\n");
        }
    }
}
