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
        v.reservaAsientos(3);
        v.reservaAsientos(7);
        v.reservaAsientos(8);
        v.reservaAsientos(2);
        sleep(1000);
    } catch (Exception e) {
    }finally{
        s.release();
    }
}
}
