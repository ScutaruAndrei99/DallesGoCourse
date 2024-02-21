package course3.exercitiul1;

public class Consumer extends Thread {
    private Buffer buffer;
    public Consumer(Buffer buffer){
        this.buffer=buffer;
    }
    public void run(){
        try{
            int item=buffer.consume();
            processItem();
            System.out.println("Am intrat in consumer: "+ item);
            Thread.sleep(1500);
        } catch (InterruptedException error){
            error.printStackTrace();
        }
    }
    private void processItem(){
        System.out.println("A intrat in consumer");
    }
}
