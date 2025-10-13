public class Medicamento extends Servicios {

    //atributos privados de medicamento
    private String indicacion;
    private int cantidad;

    //lo mismo que en tratamiento pero tomando en cuenta los atributos exclusivos de medicamento
    public Medicamento(int id, String nombre, double precio, String indicacion, int cantidad) {
        super(id, nombre, precio);
        this.indicacion = indicacion;
        this.cantidad = cantidad;
    }

    //Getters
    public String getIndicacion() {
        return indicacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    //Setters
    public void setIndicacion(String indicacion) {
        this.indicacion = indicacion;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    //toString IMPORTANTE AGREGARLO
    public String toString() {
        return "=======Información del Medicamento======= " +
                "\nID: " + id +
                "\nNombre: " + nombre +
                "\nPrecio: " + precio +
                "\nIndicaciones: " + indicacion +
                "\nCantidad: " + cantidad + "\n";
    }
}
