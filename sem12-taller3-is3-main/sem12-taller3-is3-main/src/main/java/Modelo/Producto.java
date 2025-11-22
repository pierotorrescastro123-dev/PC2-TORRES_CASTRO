package Modelo;

import java.util.Objects;

public class Producto {

    private String nombre;
    private double precio;
    private int cantidad;
    private String sku;
    private String categoria;
    private boolean esActivo;
    private boolean descuentoAplicable;

    // Constructor completo
    public Producto(String nombre, double precio, int cantidad,
                    String sku, String categoria,
                    boolean esActivo, boolean descuentoAplicable) {

        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa.");
        }
        if (sku == null || sku.trim().isEmpty()) {
            throw new IllegalArgumentException("SKU no puede ser nulo o vacío.");
        }

        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.sku = sku;
        this.categoria = categoria;
        this.esActivo = esActivo;
        this.descuentoAplicable = descuentoAplicable;
    }

    // Constructor reducido (si lo necesitas)
    public Producto(String nombre, double precio, int cantidad) {
        this(nombre, precio, cantidad, "SKU_DEFAULT", "GENERAL", true, false);
    }

    // Getters y setters con validaciones
    public String getNombre() { return nombre; }
    public
