import java.util.ArrayList;
import java.util.List;

public class Pedido {
    List<ProductoPedido> productos = new ArrayList<>();
    private double valorTotal;
    private Cliente cliente;

    public Pedido(Cliente cliente, ProductoPedido pedido) {
        this.cliente = cliente;
    }

    public void agregarProductoPedido (ProductoPedido pedido){
        this.productos.add(pedido);
    }
    public Double calcularTotal (){
        for (ProductoPedido pedido : productos){
            valorTotal += pedido.getPrecio();
        }
        return valorTotal;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "productos=" + productos +
                ", valorTotal=" + valorTotal +
                ", cliente=" + cliente +
                '}';
    }
}
