/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;
import java.util.Scanner;
/**
 *
 * @author nri
 */
public class GetInput extends AbstractUtilities {
    
    private Scanner din;    // Scanner object
        
    /*
    * Abstract method
    */
    @Override
    public void start() {
        
        System.out.printf("Initializing GetInput Object ");  
        
        // Init the Scanner
        din = new Scanner(System.in);
    }
    
    /*
    * Get user's input
    */
    public String get_user_input() {        
        // Return user's input as string
        return(din.nextLine());
    }
      
    /*
    * Check if user input is positive "yes"
    */
    public boolean check_if_yes(String _in) {
        
        _in = _in.toLowerCase();
        // Here we are checking known words for "yes" while checking that a "no"
        // does not exist anywhere in the string.
        return ( (_in.compareTo("y")==0 && _in.length()==1) || 
                _in.indexOf("yes")>=0 || 
                _in.indexOf("yeah")>0 ) && _in.indexOf("no")<0;
        
    }
    
    /*
    * Here we try to determine user's budget
    */    
    public String check_budget_type(String _in) {
        _in = _in.toLowerCase();
        String _out;
        if (_in.compareTo("eco")==0) {
            _out = "ECO";
        }
        else if (!_in.contains("eco") && _in.contains("sport")) {
            _out = "SPORTS";
        }
        else {
            _out = "not available";
        }
        
        return _out;
    }
    
}
