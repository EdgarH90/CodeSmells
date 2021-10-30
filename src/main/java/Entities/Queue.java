package Entities;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public abstract class Queue<T> {

    BlockingQueue<T> queue;

    public Queue(int size)
    {

        queue = new ArrayBlockingQueue<T>(size);
    }

    public boolean put(T item){
        boolean retVal;
        try {
            queue.put(item);
            retVal = true;
        }catch (InterruptedException e){
            retVal = false;
        }
        return retVal;
    }

    public T take(){
        T takeVal;
        try {
            takeVal = queue.take();
        }catch (InterruptedException e){
            takeVal = null;
        }
        return takeVal;
    }

}
