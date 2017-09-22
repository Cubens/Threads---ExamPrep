
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;


// @author Lasse
 
public class Consumer implements Runnable {
    
    ArrayBlockingQueue<Long> sharedCalcNumbers;

    Consumer(ArrayBlockingQueue<Long> sharedCalcNumbers)
    {
        this.sharedCalcNumbers = sharedCalcNumbers;
    }

    @Override
    public void run(){
        
    boolean moreNumbers = true;
    long totalSum = 0;
    
    while (moreNumbers) {
            
           try{
               
               Long calcedNumber = sharedCalcNumbers.poll(10, TimeUnit.SECONDS);
            
            if (calcedNumber == null){
                
                moreNumbers = false;
                System.out.println("Total Sum is: "+totalSum);
                
            } else{
                System.out.println("Retrieved a fibonacci number: "+calcedNumber);
                totalSum = totalSum + calcedNumber;
            }            
        } catch (InterruptedException interruptedException){
               System.out.println(interruptedException.getMessage());
        }
        
        }
    }
}
