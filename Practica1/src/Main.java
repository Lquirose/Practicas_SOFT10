import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static Arbol catalogo = new Arbol();
    static Cola cola1 = new Cola();
    static Random random = new Random();

    public static void main(String[] args) throws Exception {
        int opcion;
        do {
            System.out.println("MENÚ FARMACIA");
            System.out.println("1. Agregar servicio");
            System.out.println("2. Mostrar catálogo completo");
            System.out.println("3. Mostrar medicamentos");
            System.out.println("4. Mostrar tratamientos");
            System.out.println("5. Agregar cliente");
            System.out.println("6. Atender cliente");
            System.out.println("7. Salir");
            System.out.print("Opción: ");
            opcion = Integer.parseInt(in.readLine());

            switch (opcion) {
                case 1: {
                    agregarServicio();
                    break;
                }
                case 2: {
                    catalogo.enOrden(catalogo.getRaiz());
                    break;
                }
                case 3: {
                    catalogo.mostrarMedicamentos(catalogo.getRaiz());
                    break;
                }
                case 4: {
                    catalogo.mostrarTratamientos(catalogo.getRaiz());
                    break;
                }
                case 5: {
                    agregarCliente();
                    break;
                }
                case 6: {
                    atenderCliente();
                    break;
                }
                case 7: {
                    System.out.println("Saliendo...");
                    break;
                }
                default: {
                    System.out.println("Opción inválida");
                    break;
                }
            }
        } while (opcion != 7);
    }

    private static void agregarServicio() throws Exception {
        System.out.println("\nIndique el servicio de servicio:");
        System.out.println("1. Tratamiento");
        System.out.println("2. Medicamento");
        String servicio = in.readLine();

        int id = random.nextInt(100) + 1;
        System.out.print("Nombre: ");
        String nombre = in.readLine();
        System.out.print("Precio: ");
        double precio = Double.parseDouble(in.readLine());

        if (servicio.equals("1")) {
            catalogo.insertar(new Tratamiento(id, nombre, precio));
        } else if (servicio.equals("2")) {
            System.out.print("Indicaciones: ");
            String indicacion = in.readLine();
            System.out.print("Cantidad disponible: ");
            int cantidad = Integer.parseInt(in.readLine());
            catalogo.insertar(new Medicamento(id, nombre, precio, indicacion, cantidad));
        } else {
            System.out.println("Error: opción inválida.");
        }
    }

    private static void agregarCliente() throws Exception {
        System.out.print("Nombre completo: ");
        String nombre = in.readLine();
        System.out.print("Cédula: ");
        int cedula = Integer.parseInt(in.readLine());
        System.out.print("¿Es preferencialerencial? (true/false): ");
        boolean preferencial = Boolean.parseBoolean(in.readLine());

        Cliente cliente = new Cliente(nombre, cedula, preferencial, null);
        String respuesta;
        do {
            System.out.println("\nSeleccione servicio de servicio a adquirir:");
            System.out.println("1. Tratamiento");
            System.out.println("2. Medicamento");
            String servicio = in.readLine();

            if (servicio.equals("1")) {
                catalogo.mostrarTratamientos(catalogo.getRaiz());
            } else {
                catalogo.mostrarMedicamentos(catalogo.getRaiz());
            }

            System.out.print("Ingrese el ID del servicio: ");
            int id = Integer.parseInt(in.readLine());
            Nodo encontrado = catalogo.buscar(id);
            if (encontrado != null) {
                int cantidad = 1;
                if (encontrado.getDatosNodo() instanceof Medicamento) {
                    System.out.print("Cantidad: ");
                    cantidad = Integer.parseInt(in.readLine());
                }
                cliente.agregarAlCarrito(encontrado.getDatosNodo(), cantidad);
            } else {
                System.out.println("El ID no es válido.");
            }

            System.out.print("¿Agregar otro servicio? (s/n): ");
            respuesta = in.readLine();
        } while (respuesta.equalsIgnoreCase("s"));

        cola1.encolar(cliente);
        System.out.println("Cliente agregado a la fila.");
    }

    private static void atenderCliente() {
        if (cola1.estaVacia()) {
            System.out.println("No hay clientes esperando.");
            return;
        }
        Cliente atendido = cola1.desencolar();
        System.out.println("\nAtendiendo a: " + atendido.nombreCompleto);
        atendido.mostrarFactura();
    }
}
