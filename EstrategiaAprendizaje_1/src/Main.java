import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Indique el tamaño del arreglo: ");
        int n = Integer.parseInt(br.readLine());
        String[] palabras = new String[n];

        System.out.println("\nIngrese las palabras:");
        for (int i = 0; i < n; i++) {
            System.out.print("Palabra " + (i + 1) + ": ");
            palabras[i] = br.readLine();
        }

        boolean ordenado = false; // para que le aparezca la opcion de binario solo cuado esta ya ordenado
        //"Una vez ordenado el arreglo según el método elegido, el programa debe permitir al usuario realizar la búsqueda binaria de
        //alguna palabra."
        int opcion;
        do {
            System.out.println("\n1. Ordenar por selección");
            System.out.println("2. Ordenar por inserción");
            System.out.println("3. Ordenar por burbuja");
            System.out.println("4. Ordenar por mezcla (merge sort)");
            System.out.println("5. Ordenar por rápido (quick sort)");
            System.out.println("6. Realizar búsqueda binaria");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = Integer.parseInt(br.readLine());

            switch (opcion) {
                case 1:
                    Algoritmos.ordenamientoSeleccion(palabras);
                    ordenado = true;
                    System.out.println("\nArreglo ordenado por selección:");
                    imprimirArreglo(palabras);
                    break;
                case 2:
                    Algoritmos.ordenamientoInsercion(palabras);
                    ordenado = true;
                    System.out.println("\nArreglo ordenado por inserción:");
                    imprimirArreglo(palabras);
                    break;
                case 3:
                    Algoritmos.ordenamientoBurbuja(palabras);
                    ordenado = true;
                    System.out.println("\nArreglo ordenado por burbuja:");
                    imprimirArreglo(palabras);
                    break;
                case 4:
                    Algoritmos.ordenamientoMezcla(palabras, 0, palabras.length - 1);
                    ordenado = true;
                    System.out.println("\nArreglo ordenado por mezcla:");
                    imprimirArreglo(palabras);
                    break;
                case 5:
                    Algoritmos.ordenamientoRapido(palabras, 0, palabras.length - 1);
                    ordenado = true;
                    System.out.println("\nArreglo ordenado por rápido:");
                    imprimirArreglo(palabras);
                    break;
                case 6:
                    if (!ordenado) {
                        System.out.println("\nPrimero debe ordenar el arreglo antes de realizar la búsqueda binaria.");
                    } else {
                        System.out.print("\nIndique la palabra a buscar: ");
                        String clave = br.readLine();
                        int resultado = Algoritmos.busquedaBinaria(palabras, clave);

                        if (resultado != -1)
                            System.out.println("La palabra \"" + clave + "\" se encuentra en la posición " + resultado);
                        else
                            System.out.println("La palabra \"" + clave + "\" no se encuentra en el arreglo.");
                    }
                    break;
                case 7:
                    System.out.println("\nFin.");
                    break;
                default:
                    System.out.println("\nOpción no válida.");
            }

        } while (opcion != 7);
    }

    public static void imprimirArreglo(String[] arreglo) {
        for (String palabra : arreglo) {
            System.out.print(palabra + " ");
        }
        System.out.println();
    }
}
