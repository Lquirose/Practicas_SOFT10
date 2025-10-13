public class Arbol {

    //Atributos
    private Nodo raiz;

    //Constructor
    public Arbol() {
        raiz = null;
    }

    //Getter y Setter
    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo nuevaRaiz) {
        raiz = nuevaRaiz;
    }

    //Verifica si está vacío !! Importante implementarlo siempre
    public boolean esVacio() {
        return raiz == null;
    }

    //Insertar en el nodo del arbol
    public void insertar(Servicios servicioInsertar) {
        Nodo nuevoNodo = new Nodo(servicioInsertar);

        if (esVacio()) {
            raiz = nuevoNodo;
            return;
        }

        Nodo nodoActual = raiz;
        Nodo padreActual;

        while (true) {
            padreActual = nodoActual;
            if (servicioInsertar.getId() < nodoActual.getDatosNodo().getId()) {
                nodoActual = nodoActual.getHijoIzquierdo();
                if (nodoActual == null) {
                    padreActual.setHijoIzquierdo(nuevoNodo);
                    return;
                }
            } else if (servicioInsertar.getId() > nodoActual.getDatosNodo().getId()) {
                nodoActual = nodoActual.getHijoDerecho();
                if (nodoActual == null) {
                    padreActual.setHijoDerecho(nuevoNodo);
                    return;
                }
            } else {
                System.out.println("El ID ya existe, no se puede insertar duplicado.");
                return;
            }
        }
    }

    //Buscar en el arbol
    public Nodo buscar(int idBuscar) {
        if (esVacio()) {
            System.out.println("El árbol está vacío.");
            return null;
        }

        Nodo nodoTemp = raiz;
        while (nodoTemp != null) {
            if (idBuscar == nodoTemp.getDatosNodo().getId()) {
                return nodoTemp;
            } else if (idBuscar < nodoTemp.getDatosNodo().getId()) {
                nodoTemp = nodoTemp.getHijoIzquierdo();
            } else {
                nodoTemp = nodoTemp.getHijoDerecho();
            }
        }

        System.out.println("No se encontró el servicio con ID: " + idBuscar);
        return null;
    }

    //Recorridos con los ordenes
    public void enOrden(Nodo raizTemp) {
        if (raizTemp != null) {
            enOrden(raizTemp.getHijoIzquierdo());
            System.out.println(raizTemp.getDatosNodo());
            enOrden(raizTemp.getHijoDerecho());
        }
    }

    public void mostrarMedicamentos(Nodo raizTemp) {
        if (raizTemp != null) {
            mostrarMedicamentos(raizTemp.getHijoIzquierdo());
            if (raizTemp.getDatosNodo() instanceof Medicamento)
                System.out.println(raizTemp.getDatosNodo());
            mostrarMedicamentos(raizTemp.getHijoDerecho());
        }
    }

    public void mostrarTratamientos(Nodo raizTemp) {
        if (raizTemp != null) {
            mostrarTratamientos(raizTemp.getHijoIzquierdo());
            if (raizTemp.getDatosNodo() instanceof Tratamiento)
                System.out.println(raizTemp.getDatosNodo());
            mostrarTratamientos(raizTemp.getHijoDerecho());
        }
    }
}
