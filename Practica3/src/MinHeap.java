import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinHeap {
    //Variables
    private int [] minHeap;
    private int tamanio;
    private int capacidad;

    //Métodos
    //Constructor
    public MinHeap(int capacidad){
        this.capacidad = capacidad;
        this.tamanio = 0;
        this.minHeap = new int [capacidad];
    }

    //Fórmulas y búsqueda de hijos, padres y hoja.

    //Padre (i - 1)/2
    public int padre(int i){
        return (i - 1 ) / 2;
    }

    //Hijo Izquierdo 2i + 1
    public int hijoIzquierdo(int i){
        return 2 * i + 1;
    }

    //Hijo Derecho 2i + 2
    public int hijoDerecho(int i){
        return 2 * i + 2;
    }

    private boolean esHoja (int i){
        return i >= tamanio/2 && i < tamanio;
    }

    //Insertar elementos
    public void Insertar(int elemento){
        if (tamanio == capacidad) {
            System.out.println("El montículo está lleno");
            return;
        }
        minHeap[tamanio] = elemento;
        upHeapify(tamanio);
        tamanio++;
    }

    private void upHeapify(int i) {
        while (i > 0 && minHeap[i] < minHeap[padre(i)]) {
            cambio(i, padre(i));
            i = padre(i);
        }
    }
    public void downHeapify(int i){
        while (!esHoja(i)){

            int izquierdo = hijoIzquierdo(i);
            int derecho = hijoDerecho(i);
            int minimo = i;

            if (izquierdo < tamanio && minHeap[izquierdo] < minHeap[minimo]){
                minimo = izquierdo;
            }
            if (derecho < tamanio && minHeap[derecho] < minHeap[minimo]){
                minimo = derecho;
            }
            if (minimo == i){
                return;
            }
            cambio(i, minimo);
            i = minimo;
        }
    }

    public int peek(){
        if (tamanio == 0) {
            System.out.println("Montículo vacío");
            return -1;
        }
        return minHeap[0];
    }

    public void heapify(int [] arreglo){
        if (arreglo.length > capacidad){
            System.out.println("El arreglo excede la capacidad");
        }

        this.minHeap = arreglo;
        this.tamanio = arreglo.length;

        for (int i = (tamanio / 2) -1; i >= 0; i--){
            downHeapify(i);
            }
    }

    private void cambio(int i, int j) {
        int temp = minHeap[i];
        minHeap[i] = minHeap[j];
        minHeap[j] = temp;
    }


    public int eliminarMin(){
        if (tamanio == 0) {
            System.out.println("Montículo vacío");
            return -1;
        }

        int eliminado = minHeap[0];
        minHeap[0] = minHeap[tamanio - 1];
        tamanio--;

        downHeapify(0);
        return eliminado;
    }

    public int getTamanio() {
        return tamanio;
    }


    public int getElemento(int i) {
        return minHeap[i];
    }

    public void menu() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int opcion;

        do {
            System.out.println("\nMonticulo Minimo");
            System.out.println("1. Insertar");
            System.out.println("2. Eliminar mínimo");
            System.out.println("3. Peek (ver mínimo)");
            System.out.println("4. Heapify arreglo");
            System.out.println("5. Mostrar heap");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(br.readLine());

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese elemento: ");
                    Insertar(Integer.parseInt(br.readLine()));
                    break;
                case 2:
                    System.out.println("Eliminado: " + eliminarMin());
                    break;
                case 3:
                    System.out.println("Mínimo: " + peek());
                    break;
                case 4:
                    System.out.print("Tamaño del arreglo: ");
                    int t = Integer.parseInt(br.readLine());
                    int[] arr = new int[t];
                    for (int i = 0; i < t; i++) {
                        System.out.print("Elemento " + i + ": ");
                        arr[i] = Integer.parseInt(br.readLine());
                    }
                    heapify(arr);
                    System.out.println("Heap creado tomando como referencia los elementos del el arreglo.");
                    break;
                case 5:
                    mostrarHeap();
                    break;
            }
        } while (opcion != 6);
    }

    public void mostrarHeap() {

        if (tamanio == 0) {
            System.out.println("Montículo vacío");
            return;
        }

        System.out.println("\n-Montíulo-\n");

        for (int i = 0; i <= (tamanio / 2) - 1; i++) {

            System.out.println("Padre: " + minHeap[i]);

            // Hijo izquierdo
            int hijoIzq = 2 * i + 1;
            if (hijoIzq < tamanio) {
                System.out.println("  Hijo izquierdo: " + minHeap[hijoIzq]);
            } else {
                System.out.println("  Hijo izquierdo: (no existe)");
            }

            // Hijo derecho
            int hijoDer = 2 * i + 2;
            if (hijoDer < tamanio) {
                System.out.println("  Hijo derecho: " + minHeap[hijoDer]);
            } else {
                System.out.println("  Hijo derecho: (no existe)");
            }

            System.out.println();
        }
    }

}