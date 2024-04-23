package Analisis_Organizacion_Informacion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;

public class Analisis_Registros {
    private List<Venta> registros;

    public Analisis_Registros() {
        registros = new ArrayList<>();
    }

    public void agregarRegistro(Venta venta) {
        registros.add(venta);
    }

}