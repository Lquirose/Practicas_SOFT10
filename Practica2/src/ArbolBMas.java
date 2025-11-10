public class ArbolBMas {

    private final int orden;
    private NodoArbolBMas raiz;

    public ArbolBMas(int orden) {
        this.orden = orden;
        raiz = new NodoArbolBMas(true);
    }

    //Inserción de una llave en el árbol B+.
    public void insertar(int llave, String dato) {
        if (raiz.getLlaves().size() == orden - 1) {
            NodoArbolBMas nuevaRaiz = new NodoArbolBMas(false);
            nuevaRaiz.getHijos().add(raiz);
            dividirHijo(nuevaRaiz, 0);
            raiz = nuevaRaiz;
        }
        insertarNoLleno(raiz, llave, dato);
    }

    private void insertarNoLleno(NodoArbolBMas nodo, int llave, String dato) {
        int i = nodo.getLlaves().size() - 1;
        if (nodo.esHoja()) {
            nodo.insertarClave(llave, dato);
        } else {
            while (i >= 0 && llave < nodo.getLlaves().get(i)) i--;
            i++;
            NodoArbolBMas hijo = nodo.getHijos().get(i);
            if (hijo.getLlaves().size() == orden - 1) {
                dividirHijo(nodo, i);
                if (llave > nodo.getLlaves().get(i)) i++;
            }
            insertarNoLleno(nodo.getHijos().get(i), llave, dato);
        }
    }

    private void dividirHijo(NodoArbolBMas padre, int indice) {
        NodoArbolBMas hijo = padre.getHijos().get(indice);
        NodoArbolBMas nuevo = hijo.dividir(orden);
        int llaveSube = nuevo.esHoja() ? nuevo.getLlaves().get(0) :   //El ? es como una comparación el true está antes de los : y el false después.
                hijo.getLlaves().remove(hijo.getLlaves().size() - 1);

        padre.getLlaves().add(indice, llaveSube);
        padre.getHijos().add(indice + 1, nuevo);
    }

    //Búsqueda por clave
    public String buscar(int llave) {
        return buscarNodo(raiz, llave);
    }

    private String buscarNodo(NodoArbolBMas nodo, int llave) {
        int i = 0;
        while (i < nodo.getLlaves().size() && llave > nodo.getLlaves().get(i)) i++;
        if (nodo.esHoja()) {
            if (i < nodo.getLlaves().size() && llave == nodo.getLlaves().get(i))
                return nodo.getDatos().get(i);
            return null;
        } else {
            return buscarNodo(nodo.getHijos().get(i), llave);
        }
    }

    //Eliminación sin fusiones
    public void eliminar(int llave) {
        eliminarNodo(raiz, llave);
    }

    private void eliminarNodo(NodoArbolBMas nodo, int llave) {
        if (nodo.esHoja()) {
            int i = nodo.getLlaves().indexOf(llave);
            if (i != -1) {
                nodo.getLlaves().remove(i);
                nodo.getDatos().remove(i);
            }
        } else {
            int i = 0;
            while (i < nodo.getLlaves().size() && llave > nodo.getLlaves().get(i)) i++;
            eliminarNodo(nodo.getHijos().get(i), llave);
        }
    }

    //Recorre y muestra por rango recuperado
    public void recorrer(int llaveInicio, int n) {
        NodoArbolBMas actual = raiz;
        while (!actual.esHoja()) {
            int i = 0;
            while (i < actual.getLlaves().size() && llaveInicio > actual.getLlaves().get(i)) i++;
            actual = actual.getHijos().get(i);
        }
        boolean encontrado = false;
        while (actual != null && n > 0) {
            for (int i = 0; i < actual.getLlaves().size(); i++) {
                if (!encontrado && actual.getLlaves().get(i) < llaveInicio) continue;
                encontrado = true;
                System.out.println(actual.getLlaves().get(i) + " -> " + actual.getDatos().get(i));
                n--;
                if (n == 0) return;
            }
            actual = actual.getEnlace();
        }
    }

    //Impresión del arbol B+
    public void imprimirArbol() {
        imprimirNodo(raiz, "", true);
    }

    private void imprimirNodo(NodoArbolBMas nodo, String indentacion, boolean esUltimo) {
        System.out.println(indentacion + "+- " + (nodo.esHoja() ? "Hoja" : "Interno") + " " + nodo.getLlaves());
        indentacion += esUltimo ? "   " : "|  ";
        for (int i = 0; i < nodo.getHijos().size(); i++)
            imprimirNodo(nodo.getHijos().get(i), indentacion, i == (nodo.getHijos().size() - 1));
    }
}
