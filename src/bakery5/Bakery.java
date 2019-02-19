/** 
 * IST 411  Lab #2
 * Bakery.java 
 * Purpose: to start all of the 
 * processes that happen in the bakery
 * AKA creating customers, a clerk, a 
 * take a number and shop object
 * then starts the customer and clerk threads
 * 
 * @version 1.1 1/20/2019
 * @author Emily Good 
 */ 

package bakery5;

public class Bakery {   //comment
    public static void main(String args[]) {
        System.out.println( "Starting clerk and customer threads" );
        TakeANumber numberGadget = new TakeANumber();
        Shop shopGadget = new Shop();
        Clerk clerk = new Clerk(numberGadget, shopGadget);
        clerk.start();
        
        
        for (int k = 0; k < 10; k++) {
            Customer customer = new Customer(numberGadget, shopGadget);
            customer.start();
        }// for()
    } // main()
} // Bakery
