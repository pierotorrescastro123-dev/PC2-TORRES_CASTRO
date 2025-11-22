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
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) {
        if (precio < 0) throw new IllegalArgumentException("El precio no puede ser negativo.");
        this.precio = precio;
    }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) {
        if (cantidad < 0) throw new IllegalArgumentException("Cantidad negativa no permitida.");
        this.cantidad = cantidad;
    }

    public String getSku() { return sku; }
    public void setSku(String sku) {
        if (sku == null || sku.trim().isEmpty()) {
            throw new IllegalArgumentException("SKU no puede ser nulo o vacío.");
        }
        this.sku = sku;
    }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public boolean isEsActivo() { return esActivo; }
    public void setEsActivo(boolean esActivo) { this.esActivo = esActivo; }

    public boolean isDescuentoAplicable() { return descuentoAplicable; }
    public void setDescuentoAplicable(boolean descuentoAplicable) {
        this.descuentoAplicable = descuentoAplicable;
    }

    // equals y hashCode basados SOLO en sku
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(sku, producto.sku);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku);
    }

    // toString opcional
    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                ", sku='" + sku + '\'' +
                ", categoria='" + categoria + '\'' +
                ", esActivo=" + esActivo +
                ", descuentoAplicable=" + descuentoAplicable +
                '}';
    }
}
