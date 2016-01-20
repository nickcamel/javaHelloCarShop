/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author nri
 */
public class Sleep {
    
    /*
    * Timer for sleeping.
    */
    public static void sleep_for(int t_) {
        try {
            TimeUnit.MILLISECONDS.sleep(t_);
            //Thread.sleep(t_);
            //TimeUnit.MICROSECONDS.sleep(t_);
            //TimeUnit.SECONDS.sleep(t_);
        }
        catch (InterruptedException ie) {
            // Appareantly exception needs to be catched, in case
            // sleep is interrupted (which it can be... 
            // I don't know how, but it can!).
            System.out.printf("... you woke me up!\n");            
        }
        
    }
    
    
}
