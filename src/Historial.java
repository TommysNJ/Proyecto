import java.util.Stack;

public class Historial {
    private Stack<Pedido> pilaHistorial = new Stack<>();

    public void agregarPedido (Pedido pedido){
        pilaHistorial.push(pedido);
    }
    public Stack<Pedido> getPilaHistorial (){
        return pilaHistorial;
    }
    public void borrar (){

    }

    @Override
    public String toString() {
        return "***Historial***\n" + pilaHistorial;
    }
}
