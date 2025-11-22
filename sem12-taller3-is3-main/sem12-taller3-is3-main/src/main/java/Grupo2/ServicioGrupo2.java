package Grupo2;

import Modelo.Producto;
import java.util.List;

public class ServicioGrupo2 {

    public static boolean verificarLimite(double total){
        // Valida que el total no supere el límite de 5000
        return total <= 5000;
    }

    public static boolean validarDescuento(double descuento){
        // Permite solo descuentos entre 0 y 50%
        return descuento >= 0 && descuento <= 50;
    }

    public static double calcularIGV(double total){
        // Aplica el IGV al total (18%)
        return total * 1.18;
    }

    public static boolean validarCliente(String nombre) {
        // El nombre no puede ser nulo ni cadena vacía
        return nombre != null && !nombre.trim().isEmpty();
    }

    public static boolean verificarStock(List<Producto> productos){
        // Todos los productos deben tener cantidad mayor a 0
        return productos.stream()
            .allMatch(p -> p.getCantidad() > 0);
    }
}
