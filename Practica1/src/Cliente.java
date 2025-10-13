import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Cliente {

    //Atributos
    protected String nombreCompleto;
    protected int cedula;
    protected boolean preferencial;
    protected NodoCarrito carrito;
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    //constructor
    public Cliente(String nombreCompleto, int cedula, boolean preferencial, Nodo carrito) {
        this.nombreCompleto = nombreCompleto;
        this.cedula = cedula;
        this.preferencial = preferencial;
        this.carrito = null;
    }

    //Agregar al carrito
    public void agregarAlCarrito(Servicios servicio, int cantidad) {
        NodoCarrito nuevo = new NodoCarrito(servicio, cantidad);
        if (carrito == null) {
            carrito = nuevo;
        } else {
            NodoCarrito actual = carrito;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    //Mostrar factura
    public void mostrarFactura() {
        if (carrito == null) {
            System.out.println("El carrito está vacío.");
            return;
        }

        double total = 0;
        NodoCarrito actual = carrito;
        System.out.println("\n FACTURA ");
        System.out.println("Cliente: " + nombreCompleto + "\n"
                + "Cédula: " + cedula + "\n");

        while (actual != null) {
            Servicios s = actual.servicio;
            double subtotal = s.getPrecio();

            if (s instanceof Medicamento) {
                subtotal *= actual.cantidad;
                System.out.println("Medicamento: " + s.getNombre() + " x" + actual.cantidad + " = " + subtotal);
            } else {
                System.out.println("Tratamiento: " + s.getNombre() + " = " + subtotal);
            }
            total += subtotal;
            actual = actual.siguiente;
        }

        System.out.println("----");
        System.out.println("TOTAL: " + total + "\n");
    }
}

//NodoCarrito
class NodoCarrito {
    Servicios servicio;
    int cantidad;
    NodoCarrito siguiente;

    public NodoCarrito(Servicios servicio, int cantidad) {
        this.servicio = servicio;
        this.cantidad = cantidad;
        this.siguiente = null;
    }
}
