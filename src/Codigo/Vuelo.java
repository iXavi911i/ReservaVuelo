package Codigo;

import java.util.Random;

/**
 *
 * @author Xavi
 */
public class Vuelo {
    boolean asientosDisponibles[];
    
    public Vuelo(boolean asientosDisponibles[]){
        this.asientosDisponibles = asientosDisponibles;
    }
    
    synchronized void reservaAsientos(Pasajero p)
    {
        System.out.println(Thread.currentThread().getName() + " entrando.");
        if (asientosDisponibles[p.asiento])
        {
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                System.out.println("Thread interrupted");
            }
            System.out.println("Asiento " + p.asiento + " reservado por " + p.nombre + " en " + Thread.currentThread().getName());
            asientosDisponibles[p.asiento]=false;
        }
        else
        {
            System.out.println("Asiento " + p.asiento + " no disponible");
        }
        System.out.println(Thread.currentThread().getName() + " saliendo.");
        System.out.println("----------------------------------------------");
    }
    
    synchronized int getRandom(){
        return new Random().nextInt(asientosDisponibles.length);
    }
}
