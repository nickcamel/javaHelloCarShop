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
public class Sum extends AbstractUtilities {
    
    // Get Max Array Size from defines package
    private static final int MAX_ARR_SIZE = defines.MinMax.MAX_ARR_SIZE;
    
    @Override
    public void start() {
        System.out.printf("Initializing Sum Object ");  
    }
    
    public static void do_sum(GetInput obj) {
        
        // Used in while loop. Gets true if successfully parsed user input
        boolean ok_parsing = false;
        
        while (ok_parsing==false) {
            
            try {        
                /* Init variables */
                
                int i_hit_rule = 0; // Index counter of a sign (+/-) is found                
                
                int idx_p;  // indices for positive (plus) signs
                int idx_m;  // indices for negative (minus) signs
                int idx;    // indices for both plus and minus signs
                int rule;   // indicates whether its a + or - signs by (1/-1)
                
                // Init the arrays
                int[] my_sign_idx = new int[MAX_ARR_SIZE];
                int[] my_sign_rule = new int[MAX_ARR_SIZE];        
                
                // Total sum
                double my_sum = 0;  
                
                
                /* Start interface */
                
                // Ask user to enter an expression
                SayStuff.say("sum", "");

                String user_str;        
                user_str = obj.get_user_input();
                user_str = user_str.replaceAll("\\s",""); // remove whitespace
                
                // Add a + sign in the beginning if no sign found
                // This comprises the latter algorithm of summing
                char signs[] = "+-".toCharArray();

                if (user_str.charAt(0)!=signs[0] && user_str.charAt(0)!=signs[1]) {
                    user_str = "+" + user_str;
                }
                user_str = user_str+"+";


                // find the "+"/"-" signs
                for (int startfrom=0;startfrom<user_str.length();) {          

                    idx_p = user_str.indexOf("+", startfrom);
                    idx_m = user_str.indexOf("-", startfrom);
                    
                    // Compute which of the signs (+/-) hase lowest index 
                    // (i.e comes first)
                    if (idx_p<=idx_m && idx_p!=-1 || idx_m==-1) {
                        // We found a "+" sign to be first
                        idx = idx_p;
                        
                        // Indicate a "+" sum rule
                        rule = 1;
                    }
                    else if (idx_m<=idx_p && idx_m!=-1 || idx_p==-1) {
                        // We found a "-" sign to be first
                        idx = idx_m;                
                        
                        // Indicate a "-" sum rule
                        rule = -1;
                    }
                    else {
                        // No signs found
                        idx = -1;
                        rule = 0;
                    }
                    
                    if(idx==-1) {
                        // No more signs available... break out
                        break;
                    }
                    else {                  
                        // Assign current sign's index and it's rule
                        my_sign_idx[i_hit_rule] = idx;
                        my_sign_rule[i_hit_rule] = rule;
                        i_hit_rule++;
                    }
                    
                    // Next iteration, start looking for signs starting 
                    // from the next index.
                    startfrom = idx + 1;            
                }
                
                // Number of signs (+/-) found
                int no_signs_chars = i_hit_rule;

                // Iterate of the input and sum
                // The idea here is to use "+=" for all entries, but if it's a
                // negative value (e.g -1) we sum add the value of 1 multiplied
                // by the sign rule which hopefully (if above worked) is -1.
                for (int k=0; k<no_signs_chars-1; k++) {            
                    my_sum += my_sign_rule[k]*Double.parseDouble(user_str.substring(my_sign_idx[k]+1, my_sign_idx[k+1]));                    
                }         
                
                SayStuff.say("computing", "");                
                //Sleep.sleep_for(400);                
                System.out.printf(" = %s\n", my_sum);
                
                // We managed to parse user input. Break out of while
                ok_parsing = true;
            }
            catch (Exception ie) {
                // Something went wrong!
                System.out.printf("%s", ie);
                SayStuff.say("oops", "");                
            }
        }
        
    }
    
    
}
