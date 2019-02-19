/** 
 * IST 411  Lab #2
 * Shop.java 
 * Purpose: to tell the threads
 * to wait or to notify 
 * based on the amount of customers
 * in the shop
 * 
 * @version 1.1 1/20/2019
 * @author Emily Good 
 */ 
package bakery5;


public class Shop{
 
    private int shopSize= 0;
    private int customerN;

    
    public Shop(){   
     
}//constructor
  /** 
   * keeps track of customers
   * and tells customer thread to 
   * wait if there are more than 5
   * people in the shop
   * 
   */
  
    public synchronized void enterShop(int num){    
       try{
       while (shopSize >= 5){ 
            wait();
        }//while 
       
        }/*try*/ catch(InterruptedException e) {
            System.out.println("Exception " + e.getMessage() );
        }//catch
       
       finally{
           customerN = num;
           System.out.println("customer " + customerN + " has entered the shop");
           shopSize++;
           return;  
       }//finally
       
    }//enterShop()

     /**
      * clerk lets know who left shop
      * to let other customers in
      */
    public synchronized void leaveShop(int num){
        shopSize--;
        System.out.println("Customer with ticket " + num + " has left the shop ");
        notify();
        return;
    }//leaveShop()
    
}//Shop()