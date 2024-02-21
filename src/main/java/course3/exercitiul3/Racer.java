package course3.exercitiul3;

import java.util.concurrent.Phaser;

public class Racer extends Thread{
    private Phaser phaser;
    public Racer(Phaser phaser){
        this.phaser=phaser;
    }
    public void run(){
        System.out.println("Am plecat la drum :) ");
        phaser.arriveAndAwaitAdvance();
        System.out.println("Am terminat, HAHAHA");
        phaser.arriveAndDeregister();
    }
}
