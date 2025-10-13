public class Nodo {

    private Servicios datosNodo;
    private Nodo hijoIzquierdo;
    private Nodo hijoDerecho;

    //Constructor
    public Nodo(Servicios datosNodo) {
        this.datosNodo = datosNodo;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }

    //Getters y Setters
    public Servicios getDatosNodo() {
        return datosNodo;
    }

    public void setDatosNodo(Servicios datosNodo) {
        this.datosNodo = datosNodo;
    }

    public Nodo getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(Nodo hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public Nodo getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(Nodo hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }
}
