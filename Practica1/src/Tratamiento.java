

public class Tratamiento extends Servicios{

    //inicializo con el super los mismos atributos que heredo.
    public Tratamiento( int id, String nombre, double precio) {
        super(id, nombre, precio);
    }

    //toString IMPORTANTE AGREGARLO
    public String toString(){
        return "=======Informaci+on del tratamiento======= " +
                "ID: " + id +
                "\nNombre: " + nombre +
                "\nPrecio: " + precio + "\n";
    }
}