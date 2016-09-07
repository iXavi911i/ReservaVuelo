package Codigo;


import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Xavi
 */

public class Terminal extends Thread {
String name;
Semaphore s;
Vuelo v;
ArrayList<Pasajero> pasajeros;

public Terminal(Semaphore s, String name, Vuelo v, ArrayList<Pasajero> ps){
    this.s = s;
    this.setName(name);
    this.v = v;
    pasajeros = ps;
}

@Override
public void run(){
    try {
        s.acquire();
        pasajeros.stream().forEach((p) -> {
            v.reservaAsientos(p);
        });
        sleep(1000);
    } catch (Exception e) {
    }finally{
        s.release();
    }
}
}
