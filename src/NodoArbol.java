public class NodoArbol {
    private int valor;
    private NodoArbol nodoIzquierdo;
    private NodoArbol nodoDerecho;

    public NodoArbol (int valor){
        this.valor = valor;
        this.nodoIzquierdo = null;
        this.nodoDerecho = null;
    }

    public NodoArbol getNodoIzquierdo() {
        return nodoIzquierdo;
    }

    public NodoArbol getNodoDerecho() {
        return nodoDerecho;
    }
}
