
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


// @author Lasse
 
public class Main {
    public static void main(String[] args)
    {
        ArrayBlockingQueue<Integer> numbers = new ArrayBlockingQueue(15);
        numbers.addAll(Arrays.asList(4,5,8,12,21,22,34,35,36,37,42));
        
        ArrayBlockingQueue<Long> sharedCalcNumbers  = new ArrayBlockingQueue(15);
        
        ExecutorService es = Executors.newCachedThreadPool();
        
        es.execute(new Producer(numbers, sharedCalcNumbers));
        es.execute(new Producer(numbers, sharedCalcNumbers));
        es.execute(new Producer(numbers, sharedCalcNumbers));
        es.execute(new Producer(numbers, sharedCalcNumbers));
        
        es.execute(new Consumer(sharedCalcNumbers));
        
        es.shutdown();
        System.out.println("Main Thread Closed");
    }
}
