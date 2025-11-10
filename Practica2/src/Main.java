import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArbolBMas arbol = new ArbolBMas(4);
        int opcion = -1;

        do {
            System.out.println("Selecciona una opcion");
            System.out.println("1. Insertar elemento");
            System.out.println("2. Buscar elemento");
            System.out.println("3. Eliminar elemento");
            System.out.println("4. Recorrer");
            System.out.println("5. Imprimir el árbol");
            System.out.println("0. Salir");

            try {
                opcion = Integer.parseInt(br.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Intente de nuevo.");
                continue;
            }

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese la clave (debe ser un número entero): ");
                    int clave = Integer.parseInt(br.readLine());
                    System.out.print("Ingrese el dato asociado a esa clave: ");
                    String dato = br.readLine();
                    arbol.insertar(clave, dato);
                    System.out.println("Se ha insertado correctamente.");
                }

                case 2 -> {
                    System.out.print("Ingrese la clave que desea buscar: ");
                    int clave = Integer.parseInt(br.readLine());
                    String resultado = arbol.buscar(clave);
                    if (resultado != null)
                        System.out.println("Dato encontrado: " + resultado);
                    else
                        System.out.println("Clave no encontrada.");
                }

                case 3 -> {
                    System.out.print("Ingrese la clave a eliminar: ");
                    int clave = Integer.parseInt(br.readLine());
                    arbol.eliminar(clave);
                    System.out.println("Elemento eliminado");
                }

                case 4 -> {
                    System.out.print("Ingrese la clave de inicio: ");
                    int inicio = Integer.parseInt(br.readLine());
                    System.out.print("Cantidad de elementos por recorrer: ");
                    int n = Integer.parseInt(br.readLine());
                    arbol.recorrer(inicio, n);
                }

                case 5 -> arbol.imprimirArbol();

                case 0 -> System.out.println("Saliendo");

                default -> System.out.println("Valor inválido. Intente nuevamente.");
            }

        } while (opcion != 0);
    }
}
