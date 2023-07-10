public class ProductoPedido {
    private Producto producto;
    private int cantidad;
    private double precio;

    public ProductoPedido(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        precio = producto.getPrecio()*cantidad;
    }

    // Métodos getter y setter

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "----------------------------\n" +
                producto + "\nCantidad: " + cantidad + "\nPrecio por producto: " + precio + "\n";
    }

}
