package course3.exercitiul1;

public class Main {
    public static void main(String[] args) {
        Buffer buffer =new Buffer(5);
        Producer producer=new Producer(buffer);
        Consumer consumer=new Consumer(buffer);

        producer.start();
        consumer.start();
    }
}
