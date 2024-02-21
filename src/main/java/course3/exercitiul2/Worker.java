package course3.exercitiul2;

import java.util.concurrent.CountDownLatch;

/**Implementati o solutie folosing
 *
 */
public class Worker extends Thread{
    private CountDownLatch latch;

    public Worker(CountDownLatch latch) {
        this.latch=latch;

    }
    public void run(){
        System.out.println("Working...");
        latch.countDown();
    }
}
