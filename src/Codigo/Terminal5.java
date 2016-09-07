package Codigo;


import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
        v.reservaAsientos(new Pasajero("John",13));
        v.reservaAsientos(new Pasajero("Panfila",10));
        v.reservaAsientos(new Pasajero("Lol",2));
        v.reservaAsientos(new Pasajero("No se",9));
        sleep(1000);
    } catch (Exception e) {
    }finally{
        s.release();
    }
}
}
