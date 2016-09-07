package Codigo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Xavi
 */
public class Vuelo {
    boolean asientosDisponibles[];
    
    public Vuelo(boolean asientosDisponibles[]){
        this.asientosDisponibles = asientosDisponibles;
    }
    //
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
}
