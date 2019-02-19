/** 
 * IST 411  Lab #2
 * Customer.java 
 * Purpose: to have customers 
 * enter and take a number when
 * the shops capacity us 5 or under
 * 
 * @version 1.1 1/20/2019
 * @author Emily Good 
 */ 

package bakery5;

public class Customer extends Thread {
  
    private static int number = 10000;      // Initial ID number
    private int id;
    private TakeANumber takeANumber;
    private Shop shop;
  
    /** 
     * Customer() constructor gives each customer a reference
     *  to the shared TakeANumber gadget and the shopGadget
     * and gives each an id number.
     */
    public Customer(TakeANumber gadget, Shop shopGadget) {
        id = ++number;
        takeANumber = gadget;
        shop = shopGadget;   
    }//customer constructor
  
    /**
     * run() is the main algorithm for the customer thread. It
     *  just takes a number when it enters the bakery and controls 
     * the counter for Shop.java. Also,
     *  waits to be served until the clerk calls its number.
     */
    public void run() {
      
        try {
            sleep((int)(Math.random() * 1000));
            shop.enterShop(id);
            takeANumber.nextNumber(id);
            
        } /*try*/catch (InterruptedException e) {
            System.out.println("Exception: " + e.getMessage() );
        }//catch 
        
        }//run()
    }//customer()

