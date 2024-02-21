package course3.exercitiul1;


public class Producer extends Thread{
    private Buffer buffer;

    public Producer(Buffer buffer){
        this.buffer=buffer;
    }

    public void run(){
        try{
            int item=produceItem();
            buffer.produce(item);
            System.out.println("Am creat un produs: "+item);
            Thread.sleep(1000);
        } catch (InterruptedException error){
            error.printStackTrace();
        }
    }

    private int produceItem() {
        System.out.println("Am intrat in producer");
        return (int) (Math.random()*100);
    }
}
