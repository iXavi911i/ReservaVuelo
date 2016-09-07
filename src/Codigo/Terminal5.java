package Codigo;


import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Xavi
 */
public class Terminal5 extends Thread {
String name;
Semaphore s;
Vuelo v;

public Terminal5(Semaphore s, String name, Vuelo v){
    this.s = s;
    this.setName(name);
    this.v = v;
}

@Override
public void run(){
    try {
        s.acquire();
        v.reservaAsientos(new Pasajero("John",v.getRandom()));
        v.reservaAsientos(new Pasajero("Panfila",v.getRandom()));
        v.reservaAsientos(new Pasajero("Lol",v.getRandom()));
        v.reservaAsientos(new Pasajero("No se",v.getRandom()));
        sleep(1000);
    } catch (Exception e) {
    }finally{
        s.release();
    }
}
}
