package Codigo;

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
public class Terminal2 extends Thread {
    String name;
    Semaphore s;
    Vuelo v;
    
    public Terminal2(Semaphore s, String name, Vuelo v){
        this.s = s;
        this.setName(name);
        this.v = v;
    }
    
    @Override
    public void run(){
        try {
            s.acquire();
            v.reservaAsientos(0);
            v.reservaAsientos(4);
            v.reservaAsientos(5);
            v.reservaAsientos(6);
            sleep(1000);
        } catch (Exception e) {
        }finally{
            s.release();
        }
    }
}
