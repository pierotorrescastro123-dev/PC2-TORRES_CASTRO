package Base;

import Grupo2.ServicioGrupo2;
import Modelo.Producto;
import java.util.List;

public class Pedido {

    public static double calcularTotalPedido(List<Producto> productos, double descuento) {

        if (productos == null || productos.isEmpty()) {
            throw new IllegalArgumentException("Error: no hay productos en el pedido");
        }

        double subtotal = productos.stream()
                .mapToDouble(p -> p.getPrecio() * p.getCantidad())
                .sum();

        if (subtotal <= 0) {
            throw new IllegalArgumentException("Error: monto inválido");
        }

        if (descuento < 0 || descuento > 100) {
            throw new IllegalArgumentException("Error: descuento fuera de rango");
        }

        return subtotal - (subtotal * (descuento / 100));
    }

    // Método que integra la lógica del grupo 2
    public static double calcularTotalPedidoIntegrado(List<Producto> productos,
                                                      double descuento,
                                                      String cliente) {

        if (!ServicioGrupo2.validarDescuento(descuento)) {
            throw new IllegalArgumentException("Error: Descuento fuera del límite");
        }

        if (!ServicioGrupo2.validarCliente(cliente)) {
            throw new IllegalArgumentException("Error: Cliente vacío");
        }

        if (!ServicioGrupo2.verificarStock(productos)) {
            throw new IllegalArgumentException("Error: Producto con cantidad inválida");
        }

        double total;
        try {
            total = calcularTotalPedido(productos, descuento);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error en función base");
        }

        return ServicioGrupo2.calcularIGV(total);
    }
}
