/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld;

/**
 *
 * @author nri
 */
public class HelloWorld {
    
    private static HelloWorld self; // self object
    
    private utilities.GetInput GetInput; // Get user inputs object
    private utilities.SayStuff SayStuff; // Say stuff to user object
    private utilities.Sum Sum;           // Sum alg object    
    
    private String user_name;            // the user's name
    private String user_car;
    
    private carshop.CarShop car_shop;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Construct HelloWorld Object
        self = new HelloWorld();
        
        // Contruct and init objects.
        self.GetInput = new utilities.GetInput();
        self.GetInput.init();
        
        self.SayStuff = new utilities.SayStuff();
        self.SayStuff.init();
        
        self.Sum = new utilities.Sum();
        self.Sum.init();
        
        // Start calculator program (this includes welcoming etc...)
        self.try_calc();
        
        
        // Init and Start the Carshop program
        self.car_shop = new carshop.CarShop();        
        self.try_cars();
        
        
    }
    
    public void try_calc() {
                       
        // Welcome the user
        self.SayStuff.say("hello", "");        
        self.SayStuff.say("askname", "");
        
        // Get user's name
        self.user_name = self.GetInput.get_user_input();
        
        // Introduce the user
        self.SayStuff.say("hiname", self.user_name);                
        self.SayStuff.say("explain1", "");
        
        // Try the sum-computation
        self.Sum.do_sum(self.GetInput);
        self.SayStuff.say("sumworked", "");        
    }
    
    public void try_cars() {        
        
        /* Introduce to car shop */
        self.SayStuff.say("initcars", self.user_name);
        
        /* Choose a car */
        self.pick_car();
                
        /* New car pops up */
        self.SayStuff.say("newcar", self.user_name);
        
        // Car budget type
        String budget_type = "not available";        
        
        String _in;
        // Keep asking user if answer not accepted
        while (budget_type.contentEquals("not available")) {
            self.SayStuff.say("ecoorsports", "");
            
            // Get user input ECO/SPORTS
             _in = self.GetInput.get_user_input();
        
            budget_type = self.GetInput.check_budget_type(_in);  
            
        }
       
        // Add the car to carshop.
        self.car_shop.add_new_car(budget_type);
        utilities.Sleep.sleep_for(2000);
        
        pick_car();
        
        self.SayStuff.say("goodbye", self.user_name);
    }
    
    private void pick_car() {
        
        self.car_shop.print_cars();
        self.user_car = "";
        
        while (self.car_shop.set_main_car(self.user_car)==false) {
            self.SayStuff.say("pickcar", "");
            self.user_car = self.GetInput.get_user_input();
        }
    
        self.car_shop.print_car();
        self.SayStuff.say("excellentchoice", "");
        
        /* Tune car */
        self.SayStuff.say("tunecar", "");
        
        // Get user input yes/no
        String _in = self.GetInput.get_user_input();

        if (self.GetInput.check_if_yes(_in)) {
            System.out.println("Exciting!!! Let's do it.");
        }
        else {
            System.out.println("I'll do it anyway!");
        }
        
        // Tune car regardless of user input
        self.SayStuff.say("tuningcar", "");        
        
        self.car_shop.tune_car();
        self.car_shop.print_car();
        
        /* Negotiate price */
        self.SayStuff.say("negotiateprice", "");
        
        // Get user input yes/no
        _in = self.GetInput.get_user_input();
        
        if (self.GetInput.check_if_yes(_in)) {
            System.out.println("Why not ey?");
            self.car_shop.negotiate_price();
        }
        else {
            System.out.println("Appareantly money is not an issue!");
        }        
        utilities.Sleep.sleep_for(1000);
        
        // Wrap up the offer
        self.SayStuff.say("finaloffer", "");
        
        self.car_shop.print_car();
        
    }
    
   
    
}
