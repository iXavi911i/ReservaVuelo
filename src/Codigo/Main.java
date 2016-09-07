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
public class Main extends Thread {
    public static void main(String[] args) {
        boolean asientos[] = {true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true};
        Vuelo v = new Vuelo(asientos);
        //
        Semaphore s = new Semaphore(2,true);
        Terminal1 t1 = new Terminal1(s,"Terminal 1",v);
        Terminal2 t2 = new Terminal2(s,"Terminal 2",v);
        Terminal3 t3 = new Terminal3(s,"Terminal 3",v);
        Terminal4 t4 = new Terminal4(s,"Terminal 4",v);
        Terminal5 t5 = new Terminal5(s,"Terminal 5",v);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        try {
            t1.join();
            t1.join();
            t1.join();
            t1.join();
            t1.join();
        } catch (Exception e) {
        }
    }
}
