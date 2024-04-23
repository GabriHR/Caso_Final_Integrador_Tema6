package Mapas_Asociacion_Datos;

import javax.swing.*;

public class Gestion_Relaciones_Window extends JFrame {
    private Gestion_Relaciones relaciones;
    private Recuperacion_Eficiente recuperacion;
    private JTextArea textArea;

    public Gestion_Relaciones_Window(Gestion_Relaciones relaciones, Recuperacion_Eficiente recuperacion) {
        this.relaciones = relaciones;
        this.recuperacion = recuperacion;

    }
}