package course3.exercitiul3;

import java.util.concurrent.Phaser;

/**Cerințe:
 Implementați un sistem în care mai multe threaduri simulează călătoria într-o cursă, unde fiecare thread reprezintă un
 concurent. Utilizați Phaser pentru a controla fazele cursei, precum "Start", "Finish", și "Waiting for results".
 1. Fiecare concurent trebuie să înceapă cursa simultan.
 2. După ce toți concurenții au terminat cursa, se va afișa un mesaj că toți au terminat.
 *
 */
public class Main {
    public static void main(String[] args) {
        int nrRacer= 5;
        Phaser phaser= new Phaser(nrRacer);
        for (int index=1; index<=nrRacer;++index){
            Racer racer= new Racer(phaser);
            racer.start();
        }
        phaser.awaitAdvance(phaser.getPhase());
        System.out.println("Au terminat toti");
    }

}
