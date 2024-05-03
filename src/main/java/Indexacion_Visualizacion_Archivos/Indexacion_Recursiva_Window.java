package Indexacion_Visualizacion_Archivos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class Indexacion_Recursiva_Window extends JFrame {
    private JLabel directoryLabel;
    private JButton indexButton;
    private JButton listButton;
    private JButton sortButton;
    private JButton mainMenuButton;
    private JTable fileTable;
    private DefaultTableModel tableModel;

    public Indexacion_Recursiva_Window() {
        setLayout(new BorderLayout());

        // Crea la tabla para mostrar los archivos y sus rutas
        tableModel = new DefaultTableModel(new Object[]{"Archivo", "Ruta"}, 0);
        fileTable = new JTable(tableModel);
        add(new JScrollPane(fileTable), BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout()); // Cambia a GridBagLayout

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        directoryLabel = new JLabel("Directorio actual: ");
        centerPanel.add(directoryLabel, gbc);

        JLabel indexLabel = new JLabel("Haz clic para indexar archivos");
        centerPanel.add(indexLabel, gbc);

        indexButton = new JButton("Indexar archivos");
        indexButton.setPreferredSize(new Dimension(80, 40)); // Cambia el tamaño del botón
        indexButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedDirectory = fileChooser.getSelectedFile();
                    directoryLabel.setText("Directorio actual: " + selectedDirectory.getAbsolutePath());
                }
            }
        });
        centerPanel.add(indexButton, gbc);

        JLabel listLabel = new JLabel("Haz clic para listar archivos");
        centerPanel.add(listLabel, gbc);

        listButton = new JButton("Listar archivos");
        listButton.setPreferredSize(new Dimension(80, 40)); // Cambia el tamaño del botón
        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Limpia la tabla antes de llenarla
                tableModel.setRowCount(0);

                // Obtiene el directorio actual desde la etiqueta
                String directoryPath = directoryLabel.getText().replace("Directorio actual: ", "");
                File currentDirectory = new File(directoryPath);

                // Llena la tabla con los archivos del directorio actual
                File[] files = currentDirectory.listFiles();
                if (files != null) {
                    for (File file : files) {
                        tableModel.addRow(new Object[]{file.getName(), file.getAbsolutePath()});
                    }
                }
            }
        });
        centerPanel.add(listButton, gbc);

        JLabel sortLabel = new JLabel("Haz clic para ordenar archivos");
        centerPanel.add(sortLabel, gbc);

        sortButton = new JButton("Ordenar archivos A-Z");
        sortButton.setPreferredSize(new Dimension(80, 40)); // Cambia el tamaño del botón
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Limpia la tabla antes de llenarla
                tableModel.setRowCount(0);

                // Obtiene el directorio actual desde la etiqueta
                String directoryPath = directoryLabel.getText().replace("Directorio actual: ", "");
                File currentDirectory = new File(directoryPath);

                // Llena la tabla con los archivos del directorio actual
                File[] files = currentDirectory.listFiles();
                if (files != null) {
                    // Ordena los archivos alfabéticamente
                    Arrays.sort(files, new Comparator<File>() {
                        @Override
                        public int compare(File f1, File f2) {
                            return f1.getName().compareTo(f2.getName());
                        }
                    });

                    for (File file : files) {
                        tableModel.addRow(new Object[]{file.getName(), file.getAbsolutePath()});
                    }
                }
            }
        });
        centerPanel.add(sortButton, gbc);

        JLabel mainMenuLabel = new JLabel("Haz clic para volver al menú principal");
        centerPanel.add(mainMenuLabel, gbc);

        mainMenuButton = new JButton("Menú principal");
        mainMenuButton.setPreferredSize(new Dimension(80, 40)); // Cambia el tamaño del botón
        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes añadir el código para volver al menú principal
                dispose(); // Cierra esta ventana
            }
        });
        centerPanel.add(mainMenuButton, gbc);

        add(centerPanel, BorderLayout.CENTER);

        setSize(1200, 800); // Aumenta el tamaño de la ventana
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}