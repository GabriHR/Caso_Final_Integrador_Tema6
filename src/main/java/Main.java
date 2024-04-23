import Analisis_Organizacion_Informacion.Analisis_Window;
import Gestion_Datos_Dinamicos.Gestion_Datos_Window;
import Gestion_Datos_Dinamicos.ListaDatos;
import Gestion_Datos_Dinamicos.Pareja;
import Analisis_Organizacion_Informacion.Analisis_Registros;
import Analisis_Organizacion_Informacion.Ordenacion_Busqueda;
import Analisis_Organizacion_Informacion.Venta;
import Indexacion_Visualizacion_Archivos.Indexacion_Recursiva_Window;
import Indexacion_Visualizacion_Archivos.Ordenacion_Listado;
import Mapas_Asociacion_Datos.Gestion_Relaciones;
import Mapas_Asociacion_Datos.Recuperacion_Eficiente;
import Mapas_Asociacion_Datos.Gestion_Relaciones_Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.time.LocalDate;
import java.util.*;

public class Main extends JFrame implements Observer {
    private ListaDatos listaDatos;
    private JTextArea textArea;
    private Ordenacion_Busqueda ordenacionBusqueda;
    private Analisis_Registros analisisRegistros;
    private Random random;
    private Gestion_Relaciones relaciones;
    private Recuperacion_Eficiente recuperacion;

    // Nombres reales
    private String[] nombres = {"Rubén", "Nerea", "Nicolás", "José Carlos", "Daniel", "Jorge", "María", "Raúl", "Aleix", "Alex", "Carlos", "Ana", "Luis", "Sofía", "Miguel", "Patricia", "Antonio", "Carmen", "Manuel", "Teresa", "Isabel", "Francisco", "Laura", "Alberto", "Sara", "Fernando", "Susana", "Juan", "Lucía", "Diego"};

    // Nombres de productos reales
    private String[] productos = {"gafas", "toallas", "sillas", "mesas", "libros", "computadoras", "televisores", "teléfonos", "relojes", "zapatos", "camisas", "pantalones", "sombreros", "guantes", "bufandas", "corbatas", "mochilas", "carteras", "auriculares", "ratones", "teclados", "monitores", "altavoces", "lámparas", "cámaras", "bicicletas"};

    public Main() {
        listaDatos = new ListaDatos();
        listaDatos.addObserver(this);

        ordenacionBusqueda = new Ordenacion_Busqueda();
        analisisRegistros = new Analisis_Registros();
        random = new Random();

        // Crear una instancia de Gestion_Relaciones
        relaciones = new Gestion_Relaciones();
        relaciones.agregarRelacion(1, "uno");
        relaciones.agregarRelacion(2, "dos");

        // Crear una instancia de Recuperacion_Eficiente
        recuperacion = new Recuperacion_Eficiente();
        recuperacion.agregarAsociacion(1, 'a');
        recuperacion.agregarAsociacion(2, 'b');

        setLayout(new BorderLayout());

        // Inicializar textArea
        textArea = new JTextArea();
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Define GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Define the button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());

        // Define the exit button
        JButton exitButton = new JButton("Salir");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Cerrar la aplicación
            }
        });

        //BOTON PARA AGREGAR DATOS
        JButton addButton = new JButton("Agregar dato");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Instancia la clase GestionDatosWindow para abrir la nueva ventana
                new Gestion_Datos_Window(listaDatos);
            }
        });

        //BOTON PARA EL ANALISIS DE REGISTROS
        JButton analysisButton = new JButton("Análisis de registro");
        analysisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Generar al menos tantas transacciones de venta como nombres y productos tienes
                int numVentas = Math.max(nombres.length, productos.length);
                for (int i = 0; i < numVentas; i++) {
                    String cliente = nombres[random.nextInt(nombres.length)];
                    String producto = productos[random.nextInt(productos.length)];
                    double cantidad = Math.round(random.nextDouble() * 1000); // Generar números aleatorios de hasta tres dígitos
                    LocalDate fecha = LocalDate.now().minusDays(random.nextInt(365));
                    Venta venta = new Venta(cliente, producto, cantidad, fecha);
                    ordenacionBusqueda.agregarVenta(venta);
                    analisisRegistros.agregarRegistro(venta);
                }

                // Abrir una nueva ventana para mostrar los datos generados
                new Analisis_Window(ordenacionBusqueda, analisisRegistros);
            }
        });

        JButton gestionRelacionesButton = new JButton("Gestión de relaciones");
        gestionRelacionesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Limpiar las relaciones existentes
                relaciones = new Gestion_Relaciones();
                recuperacion = new Recuperacion_Eficiente();

                // Generar 20 relaciones
                for (int i = 1; i <= 20; i++) {
                    char letra = (char) (i + 'a'); // Generar una letra a partir del número
                    String texto = Integer.toString(i);
                    relaciones.agregarRelacion(i, texto);
                    recuperacion.agregarAsociacion(i, letra);
                }

                // Abrir la nueva ventana y mostrar las relaciones
                Gestion_Relaciones_Window window = new Gestion_Relaciones_Window(relaciones, recuperacion);
                window.mostrarRelaciones();
            }
        });

        //BOTON PARA LA RECUPERACION EFICIENTE DE DATOS
        JButton recuperacionEficienteButton = new JButton("Recuperación eficiente");
        recuperacionEficienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pedir al usuario una clave
                String claveString = JOptionPane.showInputDialog("Introduce una clave:");
                if (claveString != null) {
                    try {
                        int clave = Integer.parseInt(claveString);
                        // Recuperar y mostrar la información asociada a la clave
                        String texto = relaciones.obtenerTexto(clave);
                        char letra = recuperacion.obtenerLetra(clave);
                        JOptionPane.showMessageDialog(null, "Texto: " + texto + "\nLetra: " + letra);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "La clave debe ser un número.");
                    }
                }
            }
        });

        // Crear el botón
        JButton indexacionButton = new JButton("Indexación Recursiva");
        indexacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Indexacion_Recursiva_Window().setVisible(true);
            }
        });

        //BOTON PARA LA ORDENACION Y LISTADO DE ARCHIVOS
        JButton ordenacionListadoButton = new JButton("Ordenación y Listado");
        ordenacionListadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Instancia la clase Ordenacion_Listado para ordenar y listar los archivos
                Ordenacion_Listado ordenacionListado = new Ordenacion_Listado();

                // Abre un diálogo de selección de archivos
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setMultiSelectionEnabled(true); // Permite seleccionar varios archivos
                int returnValue = fileChooser.showOpenDialog(null);

                // Si el usuario seleccionó algunos archivos
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File[] selectedFiles = fileChooser.getSelectedFiles();

                    // Si se seleccionaron más de 4 archivos, selecciona solo los primeros 4
                    if (selectedFiles.length > 4) {
                        selectedFiles = Arrays.copyOfRange(selectedFiles, 0, 4);
                    }

                    // Ordena y lista los archivos seleccionados
                    ordenacionListado.ordenarYListar(selectedFiles);
                }
            }
        });

        // Agregar el botón al panel
        buttonPanel.add(ordenacionListadoButton);

        // Agregar los botones al panel
        buttonPanel.add(addButton);
        buttonPanel.add(analysisButton);
        buttonPanel.add(gestionRelacionesButton);
        buttonPanel.add(recuperacionEficienteButton);
        buttonPanel.add(indexacionButton);
        buttonPanel.add(exitButton);

        // Agregar el panel al JFrame principal
        add(buttonPanel, BorderLayout.SOUTH); // Ajusta la ubicación según tus necesidades

        // Panel para la imagen
        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new BorderLayout());

        // Cargar la imagen
        final ImageIcon[] imageIcon = {new ImageIcon("C:/Users/ghern/IdeaProjects/Caso_Final_Integrador_Tema6/Logo y nombre UAX.jpg")};
        JLabel imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setVerticalAlignment(JLabel.CENTER);

        // Agregar un ComponentListener para escalar la imagen cuando la ventana sea redimensionada
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Image image = imageIcon[0].getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT); // Ajustar el tamaño de la imagen
                imageIcon[0] = new ImageIcon(image);
                imageLabel.setIcon(imageIcon[0]);
            }
        });

        // Agregar la imagen al JFrame principal
        add(imageLabel, BorderLayout.CENTER);

        setSize(960, 760); // Hacer la ventana más grande
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        setVisible(true);
        // Crea el JLabel para el título
        JLabel titleLabel = new JLabel("Sistema de Gestión y Análisis de Datos Multidimensionales", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20)); // Cambia la fuente y el tamaño a tu gusto

        // Agrega el JLabel al JFrame principal
        add(titleLabel, BorderLayout.NORTH);

        // Crear el JLabel
        JLabel copyrightLabel = new JLabel("© Derechos reservados por Gabriel Hernanz Rodriguez", SwingConstants.CENTER);
        copyrightLabel.setFont(new Font("Times New Roman", Font.BOLD, 12)); // Cambia la fuente a "Times New Roman" y el estilo a negrita

        // Crear un JPanel para el JLabel
        JPanel copyrightPanel = new JPanel(new BorderLayout());

        // Agregar el JLabel al JFrame principal
        add(copyrightLabel, BorderLayout.SOUTH);
    }

    @Override
    public void update(Observable o, Object arg) {
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

    public static void main(String[] args) {
        new Main();
    }

}