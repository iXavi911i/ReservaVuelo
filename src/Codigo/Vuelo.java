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
    int asientosDisponibles;
    
    public Vuelo(int asientosDisponibles){
        this.asientosDisponibles = asientosDisponibles;
    }
    
    synchronized void reservaAsientos()
    {
        System.out.println(Thread.currentThread().getName() + " entrando.");
        System.out.println("Asientos disponibles : " + asientosDisponibles);
        if (asientosDisponibles > 0)
        {
            System.out.println("Asientos disponibles)");
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                System.out.println("Thread interrupted");
            }
            System.out.println("Asiento reservado por " + queTerminal());
            asientosDisponibles = asientosDisponibles - 1;
        }
        else
        {
            System.out.println("Asientos solictados no disponibles");
        }
        System.out.println(Thread.currentThread().getName() + " saliendo.");
        System.out.println("----------------------------------------------");
    }
    
    public String queTerminal(){
        String terminal;
        switch (Thread.currentThread().getName()) {
            case "Thread-0":
                terminal = "Terminal 1";
                break;
            case "Thread-1":
                terminal = "Terminal 2";
                break;
            case "Thread-2":
                terminal = "Terminal 3";
                break;
            case "Thread-3":
                terminal = "Terminal 4";
                break;
            default:
                terminal = "Terminal 5";
                break;
        }
        return terminal;
    }
}
