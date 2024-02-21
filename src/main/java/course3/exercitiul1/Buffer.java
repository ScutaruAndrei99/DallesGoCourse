package course3.exercitiul1;

import java.util.LinkedList;

/**
 *
 */

public class Buffer {
        private LinkedList<Integer> items= new LinkedList<>();
        private int capacity;
        public Buffer(int capacity){
            this.capacity=capacity;
        }

        public synchronized void produce(int item) throws InterruptedException{
            while(items.size() == capacity){
                wait();
            }
            items.add(item);
            notifyAll();
        }
        public synchronized int consume() throws InterruptedException{
            while(items.size()==0){
                wait();
            }
            int item = items.removeFirst();
            notifyAll();
            return item;
        }
    }