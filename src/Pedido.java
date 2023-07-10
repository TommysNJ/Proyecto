import java.util.ArrayList;
import java.util.List;

public class Pedido {
    List<ProductoPedido> productos = new ArrayList<>();
    private Menu menu = new Menu();
    private double valorTotal;
    private Cliente cliente;

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void agregarProductoPedido (ProductoPedido pedido){
        productos.add(pedido);
    }
    public void calcularTotal (){
        valorTotal = 0;
        for (ProductoPedido pedido : productos){
            valorTotal += pedido.getPrecio();
        }
    }


    public String imprimirPedido (){
        return productos.toString();
    }



    @Override
    public String toString() {
        return "\n\n\n***PEDIDO***\n" + cliente +
                "\n-Productos Pedidos-\n" + productos + "----------------------------" +
                "\nValor Total: " + valorTotal;
    }
}
