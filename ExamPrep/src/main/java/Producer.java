
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;


// @author Lasse
 
public class Producer implements Runnable {
    
    ArrayBlockingQueue<Integer> numbers;
    ArrayBlockingQueue<Long> sharedCalcNumbers;

    Producer(ArrayBlockingQueue<Integer> numbers, ArrayBlockingQueue<Long> sharedCalcNumbers)
    {
        this.numbers = numbers;
        this.sharedCalcNumbers = sharedCalcNumbers;
    }

    @Override
    public void run(){
        
    boolean moreNumbers = true;
    
    while (moreNumbers) {
            
           try{
            Integer calcThis = numbers.poll();
            if (calcThis == null){
                
                moreNumbers = false;        
                System.out.println("Producer Thread Terminated");
                
            } else{
                sharedCalcNumbers.put(fib(calcThis));
            }            
        } catch (InterruptedException interruptedException){
               System.out.println(interruptedException.getMessage());
        }
        
        }
    }
    
    
    
    private long fib(long n) {
    if ((n == 0) || (n == 1)) {
      return n;
    } else {
      return fib(n - 1) + fib(n - 2);
    }
  }
    
    
    }
