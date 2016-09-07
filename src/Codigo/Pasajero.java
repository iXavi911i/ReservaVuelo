package Codigo;

/**
 *
 * @author Xavi
 */
public class Pasajero {
    String nombre;
    int asiento;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAsiento() {
        return asiento;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    public Pasajero(String nombre, int asiento){
        this.nombre=nombre;
        this.asiento=asiento;
    }
    
}
