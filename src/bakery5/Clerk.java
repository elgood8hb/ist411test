/** 
 * IST 411  Lab #2
 * Clerk.java 
 * Purpose: controls customers that 
 * are being served and lets
 * shop know when someone leaves
 * 
 * @version 1.1 1/20/2019
 * @author Emily Good 
 */ 
package bakery5;

public class Clerk extends Thread {
    private TakeANumber takeANumber;  
    private Shop shop;
    private int id;
    

    /** 
     * Clerk() constructor gives the clerk a reference to the
     *  TakeANumber gadget. and shop gadget
     */
    public Clerk(TakeANumber gadget, Shop shopGadget) {
      takeANumber = gadget;
      shop = shopGadget;
    }//clerk constructor 

    /**
     *  run() is the main algorithm for the clerk thread. Note
     *  that it runs in an infinite loop.  Note that in this version
     *  the clerk no longer checks if there are customers waiting before
     *  calling nextCustomer(). This check has been moved into the
     *  TakeANumber object itself.
     */
    public void run() {
        while(true){
            try {
               sleep((int)(Math.random() * 1000));
               id = takeANumber.nextCustomer();
               shop.leaveShop(id);
               
               
            }/*try*/ catch (InterruptedException e){
                System.out.println("Exception: " + e.getMessage() );
            }//catch
            
    }// while
 } // run()
}// Clerk
