public abstract class Servicios {

    //Atributos
    protected int id;
    protected String nombre;
    protected double precio;

    //Constructor
    public Servicios(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    //getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    //setters no se pide el id porque no se puede cambiar la idea es que sea único
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
