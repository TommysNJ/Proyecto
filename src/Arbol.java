import java.util.ArrayList;
import java.util.List;

public class Arbol {
    private NodoArbol raiz;
    private final List<ProductoPedido> productosVendidos = new ArrayList<>();

    public Arbol(){
        raiz = null;
    }

    public void insertar(ProductoPedido productoPedido){
        raiz = insertarRecursividad(raiz,productoPedido);
    }

    private NodoArbol insertarRecursividad (NodoArbol nodo, ProductoPedido productoPedido){
        if (nodo == null) {
            return new NodoArbol(productoPedido);
        }
        if (productoPedido.getCantidad() < nodo.getProductoPedido().getCantidad()) {
            nodo.setNodoIzquierdo((insertarRecursividad(nodo.getNodoIzquierdo(), productoPedido)));
        } else {
            nodo.setNodoDerecho(insertarRecursividad(nodo.getNodoDerecho(), productoPedido));
        }

        return nodo;
    }

    public List<ProductoPedido> productosMasVendidos(){
        productosVendidos.clear();
        mostrarInOrder(raiz);
        return productosVendidos;
    }

    private void mostrarInOrder (NodoArbol nodo){
        if (nodo!=null){
            mostrarInOrder(nodo.getNodoIzquierdo());
            productosVendidos.add(nodo.getProductoPedido());
            mostrarInOrder(nodo.getNodoDerecho());
        }
    }

}
