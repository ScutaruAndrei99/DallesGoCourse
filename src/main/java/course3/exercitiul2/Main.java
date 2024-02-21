package course3.exercitiul2;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int nrWorkers=5;
        CountDownLatch latch = new CountDownLatch(nrWorkers);

        for (int index=1; index <= 5; ++index){
            Worker worker= new Worker(latch);
            worker.start();

        }
        latch.await();
        System.out.println("Toti muncitorii au terminat");
    }
}
