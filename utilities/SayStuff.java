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
public class SayStuff extends AbstractUtilities {
    
    private static String str_out;     // String to be printed for user
    
    /*
    * Abstract method
    */
    @Override
    public void start() {
        System.out.printf("Initializing SayStuff Object ");  
    }

    /*
    * Most of console prints come from here
    */
    public static void say(String _in, String _in_next) {
             
       switch (_in) {
            case "hello": {
                str_out = "\n\nHello! \n";
                break;
            }
            case "askname": {
                str_out = "What is your name? ";
                break;
            }
            case "hiname": {
                str_out = "Hi %s! I'm Aant \n";
                break;
            }
            case "explain1": {
                str_out = "This is actually my first separate (public) class :)! \n"
                        + "First, I'm going to try out a sum calculator... \n"
                        + "Let's try it out! \n\n"
                        + "Let's see if I can sum? \n";
                break;
            }
            case "sum": {
                str_out = "Enter a sum-expression \n(e.g -2+9+2 or 1.98+3.77-9.1) [ENTER]: \n";
                break;
            }
            case "sumworked": {
                str_out = "Yay! Looks like it worked. \n\n";
                break;
            }
            case "computing": {
                str_out = "\t\t\tComputing ... [psst! this waiting is just theatrical, I'm already done] \n";
                break;
            }
            case "oops": {
                str_out = "\nW-Oops... Something went wrong there! \n";
                break;
            }
            case "initcars": {
                str_out = "Ok %s \n"
                        + "I've just finished building my car shop. \n"
                        + "Let\'s have a look \n";
                break;
            }
            case "pickcar": {
                str_out = "\nGo ahead and pick a car! \nType in the car's model: ";
                break;
            }
            case "excellentchoice": {
                str_out = "\nExcellent choice! \n\n";
                break;
            }
            case "tunecar": {
                str_out = "Would you like to tune your car? ";
                break;
            }
            case "tuningcar": {
                str_out = "Tuning car... please wait... \n ... ... \n"
                        + "\n";
                break;
            }            
            case "negotiateprice": {
                str_out = "Would you like to negotiate the price? \n";
                break;
            }
            case "finaloffer": {
                str_out = "\nOk, so here is the final offer! \n";
                break;
            }
            case "newcar": {
                str_out = "\nWait! ... I'm getting something here... \n"
                        + "My Manager tells me that we just received an opportunity "
                        + "here. You can now add a new car to the car shop.\n";
                break;
            }
            case "ecoorsports": {
                str_out = "\nChoose between an ECO or SPORTS type car:";
                break;
            }
            case "goodbye": {
                str_out = "\n\nThank you %s, for spending time (and money) "
                        + "on trying out\n "
                        + "my first JAVA program. \n\n"
                        + "Hope to see you in the future!\n"
                        + "Good bye!\n\n";
                break;
            }
            default: {
                str_out = "not available \n";
                break;
            }
       }
       
       // Print out wordwise with "random" delay. Making it more "human".
       int start_from = 0;
       int end_at;
       int check_format;
       double t_wait;
       
       while (start_from<str_out.length()) {
            
           // If we find "%s" we need to read in both characters i.e both "%" 
           // and "s". Otherwise "printf" won't parse the format
            check_format = str_out.indexOf("%s", start_from);
            
            if ( (check_format!=-1) && (start_from==check_format) ) {
                end_at = check_format +1 + 1;
            }
            else {
                end_at = str_out.indexOf(" ", start_from);
                if (end_at==-1) {
                    end_at = str_out.length();
                }
                else {
                    end_at += 1;
                }
            }
                       
            System.out.printf(str_out.substring(start_from, end_at) , _in_next);
            start_from = end_at;
            
            // Randomize type speed a bit.
            // For some reason, we cant go any lower than ~300ms.
            t_wait = Math.random();            
            if (t_wait<.3) {
                Sleep.sleep_for(350);
            }
            else if (t_wait<.6) {
                Sleep.sleep_for(200);
            }
            else {
                Sleep.sleep_for(500);
            }
       }     
       

    }

    
}
