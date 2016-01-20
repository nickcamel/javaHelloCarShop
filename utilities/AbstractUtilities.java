/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 *
 * @author nri
 */
/* Abstract for some of the Utilities Objects 
* We want them all to implement a identical method "init()".
* Each with a unique "start()" method but with identical "action" method.
*
*/
public abstract class AbstractUtilities {
    
    // Objects share this method. Should not be overriden.
    public void init() {
        start();
        action();        
    }
    
    // Objects override content
    public abstract void start();
     
    // Objects share this method. Should not be overriden.
    public void action() {
        System.out.printf("through AbstractUtilities ");
        Sleep.sleep_for(800);
        System.out.printf("... done \n");
    }
        
    
    
    
}
