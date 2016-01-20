/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carshop;
import java.util.ArrayList;
/**
 *
 * @author nri
 */

public class CarShop {

    // Array of cars
    private final ArrayList<Car> my_cars;
    
    // Keep track of user chosen car
    protected Car main_car;    

    
    /* Constructor */
    public CarShop() {     

        // Init array list of cars
        my_cars = new ArrayList();
        
        // Add cars to arraylist
        my_cars.add(new Bmw());
        my_cars.add(new Audi());
        my_cars.add(new Toyota());
                        
    }    
    
    /* Set user's chosen car */
    public boolean set_main_car(String _model) {
                
        _model = _model.toUpperCase();

        // Iterate over the inputed string to find a matching 
        // car in the car shop.
        for (Car my_car : my_cars) {            
           
            if (_model.compareTo(my_car.model.toUpperCase())==0) {
                // Found the car!
                // Set it and return true
                main_car = my_car;
                
                return true;
            }
        }
        
        // Car not found. Return false.
        return false;
    }
    
    /* Print all cars to console */
    public void print_cars() {
        System.out.println("______________________________________________");
        System.out.println("\nHere are the available cars: \n");        
        System.out.printf("%10s %20s %14s \n", "Model", "Max speed [km/h]", "Price [KSEK]");
        
        // For each car, print properties
        for (Car my_car : my_cars) {            
            my_car.print_car();
        }
        System.out.println("");
        
    }
    
    /* Print the main car's properties */
    public void print_car() {
        System.out.println("______________________________________________");
        System.out.printf("%10s %20s %14s \n", "Model", "Max speed [km/h]", "Price [KSEK]");
        main_car.print_car();
        System.out.println("");
    }
    
    /* Tune the chosen/main car */
    public void tune_car() {
        main_car.tune_car();
    }
    
    /* Negotiate the price of the chosen/main car */
    public void negotiate_price() {
        main_car.negotiate_price();
    }
    
    /* Add a new custom car to the car shop 
    * Here the car shop is the designer of the new car, unlike the default cars
    * which are designed in CarTemplate!! CarTemplate will however set the tuning and price negotiation...
    */
    public void add_new_car(String _budget) {
        
               
        // Add the car type to carshop, depending on user's budget
        switch (_budget) {
            case "ECO": {
                System.out.println("Adding a PEUGEOT");
                my_cars.add(new Peugeot());
                break;
            }
            case "SPORTS": {
                System.out.println("Adding a FERRARI");
                my_cars.add(new Ferrari());
                break;
            }
            default: {
                // It's a bug if we end up here!
                System.out.println("Ok this should not happen!\n");
                break;
            }
        }

    }
}   