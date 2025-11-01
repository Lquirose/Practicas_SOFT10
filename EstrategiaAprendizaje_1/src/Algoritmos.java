public class Algoritmos {


    // Selección
    // Complejidad O(n^2)
    //recorre el arreglo y busca el elemento
    // menor en la parte no ordenada, y lo intercambio al inicio.

    public static void ordenamientoSeleccion(String[] arreglo) {
        int n = arreglo.length;

        for (int i = 0; i < n - 1; i++) {
            int indiceMin = i; // asumo que el actual es el menor

            // Busca el menor elemento en la parte no ordenada
            for (int j = i + 1; j < n; j++) {
                if (arreglo[j].compareToIgnoreCase(arreglo[indiceMin]) < 0) {
                    indiceMin = j;
                }
            }

            // Intercambia el menor que este en la posición actual
            String temp = arreglo[i];
            arreglo[i] = arreglo[indiceMin];
            arreglo[indiceMin] = temp;
        }
    }

    //Inserción
    // Complejidad O(n^2)
    //en cada iteración, el elemento actual se inserta
    // en su posición correcta dentro de la parte ya ordenada.

    public static void ordenamientoInsercion(String[] arreglo) {
        int n = arreglo.length;

        for (int i = 1; i < n; i++) {
            String clave = arreglo[i]; //el elemento que va a insertar
            int j = i - 1;

            // desplaza los elementos mayores una posición a la derecha
            while (j >= 0 && arreglo[j].compareToIgnoreCase(clave) > 0) {
                arreglo[j + 1] = arreglo[j];
                j--;
            }

            // Inserta la llave en su lugar correspondiente
            arreglo[j + 1] = clave;
        }
    }

    //Burbuja
    // Complejidad O(n^2)
    //compara elementos adyacentes y los intercambia
    //si están desordenados, los mayores van “subiendo”.

    public static void ordenamientoBurbuja(String[] arreglo) {
        int n = arreglo.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arreglo[j].compareToIgnoreCase(arreglo[j + 1]) > 0) {
                    String temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
    }


    //mezcla merge sort
    // Complejidad O(n log n)
    // divide continuamente el arreglo en mitades y
    // luego las combina en orden.

    public static void ordenamientoMezcla(String[] arreglo, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int medio = (izquierda + derecha) / 2;
            ordenamientoMezcla(arreglo, izquierda, medio);
            ordenamientoMezcla(arreglo, medio + 1, derecha);
            mezclar(arreglo, izquierda, medio, derecha);
        }
    }

    private static void mezclar(String[] arreglo, int izquierda, int medio, int derecha) {
        int n1 = medio - izquierda + 1;
        int n2 = derecha - medio;
        String[] L = new String[n1];
        String[] R = new String[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arreglo[izquierda + i];
        for (int j = 0; j < n2; j++)
            R[j] = arreglo[medio + 1 + j];

        int i = 0, j = 0, k = izquierda;

        //combina ambos lados y compara los elementos
        while (i < n1 && j < n2) {
            if (L[i].compareToIgnoreCase(R[j]) <= 0) {
                arreglo[k] = L[i];
                i++;
            } else {
                arreglo[k] = R[j];
                j++;
            }
            k++;
        }

        //copia los elementos restantes
        while (i < n1) {
            arreglo[k++] = L[i++];
        }
        while (j < n2) {
            arreglo[k++] = R[j++];
        }
    }

    // Rápido quick sort
    // Complejidad O(n log n)
    // elige un pivote, divide el arreglo en dos partes
    // (menores y mayores al número o espacio del pivote) y repite el proceso en las iteraciones hasta encontrar la palabra o elemento.

    public static void ordenamientoRapido(String[] arreglo, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int indicePivote = particion(arreglo, izquierda, derecha);
            ordenamientoRapido(arreglo, izquierda, indicePivote - 1);
            ordenamientoRapido(arreglo, indicePivote + 1, derecha);
        }
    }

    private static int particion(String[] arreglo, int izquierda, int derecha) {
        String pivote = arreglo[derecha];
        int i = izquierda - 1;

        for (int j = izquierda; j < derecha; j++) {
            if (arreglo[j].compareToIgnoreCase(pivote) <= 0) {
                i++;
                String temp = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = temp;
            }
        }

        String temp = arreglo[i + 1];
        arreglo[i + 1] = arreglo[derecha];
        arreglo[derecha] = temp;

        return i + 1;
    }

    //Búsqueda binaria
    // Complejidad O(log n)
    //el arreglo debe estar ordenado. Compara el valor
    //buscado con el elemento que está en el centro y descarta se va reduciendo los índices de búsqueda a la mitad en cada iteracion.

    public static int busquedaBinaria(String[] arreglo, String clave) {
        int izquierda = 0, derecha = arreglo.length - 1;

        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            int comparacion = clave.compareToIgnoreCase(arreglo[medio]);

            if (comparacion == 0)
                return medio; //devuelvo la palabra encontada
            else if (comparacion < 0)
                derecha = medio - 1; //busco a la izq
            else
                izquierda = medio + 1; //busco a la derecha
        }
        return -1; // No se encontró
    }
}
