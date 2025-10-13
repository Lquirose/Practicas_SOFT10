public class Cola {

    private NodoCliente frente;

    public Cola() {
        frente = null;
    }

    public void encolar(Cliente nuevo) {
        NodoCliente nodoNuevo = new NodoCliente(nuevo);
        if (frente == null || nuevo.preferencial) {
            nodoNuevo.siguiente = frente;
            frente = nodoNuevo;
        } else {
            NodoCliente actual = frente;
            while (actual.siguiente != null && !actual.siguiente.datos.preferencial) {
                actual = actual.siguiente;
            }
            nodoNuevo.siguiente = actual.siguiente;
            actual.siguiente = nodoNuevo;
        }
    }

    public Cliente desencolar() {
        if (frente == null) return null;
        Cliente temp = frente.datos;
        frente = frente.siguiente;
        return temp;
    }

    public boolean estaVacia() {
        return frente == null;
    }
}

class NodoCliente {
    Cliente datos;
    NodoCliente siguiente;

    public NodoCliente(Cliente datos) {
        this.datos = datos;
        this.siguiente = null;
    }
}
