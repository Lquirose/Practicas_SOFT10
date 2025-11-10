import java.util.ArrayList;
import java.util.List;

public class NodoArbolBMas {

    //Atributos
    private boolean esHoja;
    private List<Integer> llaves;
    private List<NodoArbolBMas> hijos; //Vacía si es hoja
    private List<String> datos; //Solo en hojas
    private NodoArbolBMas enlace; //Apunta a la hoja enlace

    //Constructor
    public NodoArbolBMas(boolean esHoja) {
        this.esHoja = esHoja;
        this.llaves = new ArrayList<>();
        this.hijos = new ArrayList<>();
        this.datos = esHoja ? new ArrayList<>() : null;
        this.enlace = null;
    }

    //Getters y Setters
    public boolean esHoja() {
        return esHoja;
    }

    public List<Integer> getLlaves() {
        return llaves;
    }

    public List<NodoArbolBMas> getHijos() {
        return hijos;
    }

    public List<String> getDatos() {
        return datos;
    }

    public NodoArbolBMas getEnlace() {
        return enlace;
    }

    //Inserta una nueva clave (y su dato si es hoja)
    public void insertarClave(int llave, String dato) {
        int i = 0;
        while (i < llaves.size() && llaves.get(i) < llave) i++;
        llaves.add(i, llave);
        if (esHoja) datos.add(i, dato);
    }

    //Divide el nodo si está lleno
    public NodoArbolBMas dividir(int orden) {
        int mitad = orden / 2;
        NodoArbolBMas nuevo = new NodoArbolBMas(esHoja);

        nuevo.llaves = new ArrayList<>(llaves.subList(mitad, llaves.size()));
        llaves = new ArrayList<>(llaves.subList(0, mitad));

        if (esHoja) {
            nuevo.datos = new ArrayList<>(datos.subList(mitad, datos.size()));
            datos = new ArrayList<>(datos.subList(0, mitad));
            nuevo.enlace = this.enlace;
            this.enlace = nuevo;
        } else {
            nuevo.hijos = new ArrayList<>(hijos.subList(mitad + 1, hijos.size()));
            hijos = new ArrayList<>(hijos.subList(0, mitad + 1));
        }
        return nuevo;
    }
}
