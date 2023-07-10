import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Recomendar {
    private List<ProductoPedido> productos = new ArrayList<>();
    private ValidacionesYOrdenamiento validacion = new ValidacionesYOrdenamiento();

    public void agregarProductoPedido (ProductoPedido producto){
        ProductoPedido prod = validacion.verificacionProdPedido(producto,productos);
        if (prod!=null){
            prod.setCantidad(prod.getCantidad()+producto.getCantidad());
        } else {
            productos.add(producto);
        }
    }

    public List<String> generarArbol(){
        Arbol arbol = new Arbol();

        for (ProductoPedido productoPedido : productos){
            arbol.insertar(productoPedido);
        }
        List<ProductoPedido> productosMasVendidos = arbol.productosMasVendidos();
        Collections.reverse(productosMasVendidos);

        int nivelIndentacion = 0;
        List<String> listaProductosIndentados = new ArrayList<>();

        for (ProductoPedido productoPedido : productosMasVendidos) {
            String indentacion = obtenerIndentacion(nivelIndentacion);
            String productoIndentado = indentacion + productoPedido.getProducto().getNombre() + ": " + "Cantidad Vendida - " + productoPedido.getCantidad() +"\n";
            listaProductosIndentados.add(productoIndentado);
            nivelIndentacion++;
        }

        return listaProductosIndentados;
    }

    private String obtenerIndentacion(int nivel) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nivel; i++) {
            sb.append("    ");
        }
        return sb.toString();
    }
    

    @Override
    public String toString() {
        return "***Productos Vendidos***\n" + productos;
    }
}
