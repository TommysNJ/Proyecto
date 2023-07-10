public class NodoArbol {
    private ProductoPedido productoPedido;
    private NodoArbol nodoIzquierdo;
    private NodoArbol nodoDerecho;

    public NodoArbol (ProductoPedido productoPedido){
        this.productoPedido = productoPedido;
        this.nodoIzquierdo = null;
        this.nodoDerecho = null;
    }

    public NodoArbol getNodoIzquierdo() {
        return nodoIzquierdo;
    }

    public void setNodoIzquierdo(NodoArbol nodoIzquierdo) {
        this.nodoIzquierdo = nodoIzquierdo;
    }

    public NodoArbol getNodoDerecho() {
        return nodoDerecho;
    }

    public void setNodoDerecho(NodoArbol nodoDerecho) {
        this.nodoDerecho = nodoDerecho;
    }

    public ProductoPedido getProductoPedido() {
        return productoPedido;
    }

    public void setProductoPedido(ProductoPedido productoPedido) {
        this.productoPedido = productoPedido;
    }
}
