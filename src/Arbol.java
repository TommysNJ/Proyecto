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
    public List<ProductoPedido> productosMenosVendidos() {
        productosVendidos.clear();
        obtenerProductosMenosVendidosRecursivo(raiz);
        //List<ProductoPedido> productosMenosVendidos = new ArrayList<>();
        //obtenerProductosMenosVendidosRecursivo(raiz, productosMenosVendidos);
        return productosVendidos;
    }

    private void obtenerProductosMenosVendidosRecursivo(NodoArbol nodo) {
        if (nodo != null) {
            obtenerProductosMenosVendidosRecursivo(nodo.getNodoDerecho());
            productosVendidos.add(nodo.getProductoPedido());
            obtenerProductosMenosVendidosRecursivo(nodo.getNodoIzquierdo());
        }
    }
}
