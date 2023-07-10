import java.util.ArrayList;
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

    @Override
    public String toString() {
        return "***Productos Vendidos***\n" + productos;
    }
}
