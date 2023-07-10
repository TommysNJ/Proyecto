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

    public List<ProductoPedido> generarArbol(){
        Arbol arbol = new Arbol();

        for (ProductoPedido productoPedido : productos){
            arbol.insertar(productoPedido);
        }
        List<ProductoPedido> productosMasVendidos = arbol.productosMasVendidos();
        Collections.reverse(productosMasVendidos);
        return productosMasVendidos;
    }

    @Override
    public String toString() {
        return "***Productos Vendidos***\n" + productos;
    }
}
