package Codigo;


import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Xavi
 */
public class Terminal3 extends Thread {
String name;
Semaphore s;
Vuelo v;

public Terminal3(Semaphore s, String name, Vuelo v){
    this.s = s;
    this.setName(name);
    this.v = v;
}

@Override
public void run(){
    try {
        s.acquire();
        v.reservaAsientos(new Pasajero("Yolo",v.getRandom()));
        v.reservaAsientos(new Pasajero("Ti",v.getRandom()));
        v.reservaAsientos(new Pasajero("Jorge",v.getRandom()));
        v.reservaAsientos(new Pasajero("Juan",v.getRandom()));
        sleep(1000);
    } catch (Exception e) {
    }finally{
        s.release();
    }
}
}
