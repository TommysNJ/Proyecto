import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Historial {
    private Stack<Pedido> pilaHistorial = new Stack<>();

    public void agregarPedido (Pedido pedido){
        pilaHistorial.push(pedido);
    }
    public Stack<Pedido> getPilaHistorial (){
        return pilaHistorial;
    }
    public List<Pedido> mostrarHistorialPorNombre(String nombre){
        List<Pedido> pedido = new ArrayList<>();
        for ( Pedido ped : pilaHistorial){
            if (ped.getCliente().getCedula().equalsIgnoreCase(nombre)){
                pedido.add(ped);
            }
        }
        return pedido;
    }

    @Override
    public String toString() {
        return "***Historial***\n" + pilaHistorial;
    }
}
