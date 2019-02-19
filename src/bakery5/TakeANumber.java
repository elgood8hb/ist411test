/** 
 * IST 411  Lab #2
 * TakeANumber.java 
 * Purpose: Controls the numbers customers 
 * get and who the clerk is 
 * serving
 * 
 * @version 1.1 1/20/2019
 * @author Emily Good 
 */ 

package bakery5;

public class TakeANumber {

    private int next = 0;
    private int serving = 0;
     
/** 
 * 
 *customer gets ticket and notifies
 */
  
    public synchronized int nextNumber(int custId) {
        next = next + 1;
        System.out.println( "Customer " + custId + " takes ticket " + next );
        notify();
      
        return next;
    } // nextNumber()
  
    /**
     * tells which customer is being served
     */
    
    public synchronized int nextCustomer() {
        try {
            while (next <= serving){ 
                wait();
                System.out.println("  Clerk waiting ");  
            }//while
            
            
        }/*try*/ catch(InterruptedException e){
            System.out.println("Exception " + e.getMessage() );
            
            
        }/*catch*/finally{
            ++serving;
            System.out.println("  Clerk serving ticket " + serving );
            return serving;
            
        }//finally
    } // nextCustomer()
} // TakeANumber
