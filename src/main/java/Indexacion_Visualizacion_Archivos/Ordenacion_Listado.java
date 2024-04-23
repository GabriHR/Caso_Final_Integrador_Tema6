package Indexacion_Visualizacion_Archivos;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.*;
import java.util.List;

public class Ordenacion_Listado {

    private JFrame frame;
    private JTextArea textArea;
    private List<File> archivos;

    public Ordenacion_Listado() {
        // Inicializa la lista de archivos
        archivos = new ArrayList<>();

        // Crea una nueva ventana para mostrar los nombres de los archivos y sus rutas
        frame = new JFrame("Ordenación y Listado");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 500);

        // Crea un JTextArea para mostrar los nombres de los archivos y sus rutas
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Crea un panel para los botones
        JPanel buttonPanel = new JPanel();

        // Crea un botón para seleccionar más archivos
        JButton selectMoreButton = new JButton("Seleccionar más archivos");
        selectMoreButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setMultiSelectionEnabled(true);
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File[] selectedFiles = fileChooser.getSelectedFiles();
                if (selectedFiles.length > 4) {
                    selectedFiles = Arrays.copyOfRange(selectedFiles, 0, 4);
                }
                ordenarYListar(selectedFiles);
            }
        });

        // Crea un botón para volver al menú principal
        JButton backButton = new JButton("Volver al menú principal");
        backButton.addActionListener(e -> frame.dispose());

        // Agrega los botones al panel
        buttonPanel.add(selectMoreButton);
        buttonPanel.add(backButton);

        // Agrega el panel de botones a la ventana
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Hace visible la ventana
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void ordenarYListar(File[] archivosNuevos) {
        // Agrega los archivos seleccionados a la lista de archivos
        this.archivos.addAll(Arrays.asList(archivosNuevos));

        // Ordena los archivos alfabéticamente por nombre
        archivos.sort(Comparator.comparing(File::getName));

        // Limpia el JTextArea
        textArea.setText("");

        // Imprime los nombres de los archivos y sus rutas en el JTextArea
        for (File archivoActual : archivos) {
            if (archivoActual.isFile()) {
                textArea.append("Nombre del archivo: " + archivoActual.getName() + "\n");
                textArea.append("Ruta completa: " + archivoActual.getAbsolutePath() + "\n\n");
            }
        }
    }
}