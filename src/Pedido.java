import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Cliente cliente;
    private ProductoPedido productoPedido;
    private double valorTotal;

    public Pedido(Cliente cliente, ProductoPedido productoPedido) {
        this.cliente = cliente;
        this.productoPedido = productoPedido;
        valorTotal= productoPedido.getCantidad();
    }

    /*public List<Pedido> lista (Pedido pedido){

        List<Pedido> pedidos = new ArrayList<>();

        for (Pedido lista : pedidos){

        }
    }*/

}
