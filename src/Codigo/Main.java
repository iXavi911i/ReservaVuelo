package Codigo;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Xavi
 */
public class Main extends Thread {
    public static void main(String[] args) {
        boolean asientos[] = {true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true};
        Vuelo v = new Vuelo(asientos);
        Semaphore s = new Semaphore(5,true);
        
        ArrayList<Pasajero> ps1= new ArrayList<>();
        ArrayList<Pasajero> ps2 = new ArrayList<>();
        ArrayList<Pasajero> ps3 = new ArrayList<>();
        ArrayList<Pasajero> ps4 = new ArrayList<>();
        ArrayList<Pasajero> ps5 = new ArrayList<>();
        
        //crea bloques de 5 pasajeros
        for (int i = 0; i < 5; i++) {
            ps1.add(new Pasajero("Cliente " + i,v.getRandom()));
        }
        
        for (int i = 0; i < 5; i++) {
            ps2.add(new Pasajero("Cliente " + i,v.getRandom()));
        }
        
        for (int i = 0; i < 5; i++) {
            ps3.add(new Pasajero("Cliente " + i,v.getRandom()));
        }
        
        for (int i = 0; i < 5; i++) {
            ps4.add(new Pasajero("Cliente " + i,v.getRandom()));
        }
        
        for (int i = 0; i < 5; i++) {
            ps5.add(new Pasajero("Cliente " + i,v.getRandom()));
        }
        //
        
        //5 terminales: a cada termina se asigna un bloque de pasajeros
        Terminal t1 = new Terminal(s,"Terminal 1",v,ps1);
        Terminal t2 = new Terminal(s,"Terminal 2",v,ps2);
        Terminal t3 = new Terminal(s,"Terminal 3",v,ps3);
        Terminal t4 = new Terminal(s,"Terminal 4",v,ps4);
        Terminal t5 = new Terminal(s,"Terminal 5",v,ps5);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (Exception e) {
        }
    }
}
