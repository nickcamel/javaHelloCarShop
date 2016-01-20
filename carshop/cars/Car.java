/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carshop;

/**
 *
 * @author nri
 */
public class Car {
    
    protected String model;
    protected int price;
    protected int max_speed;
    private boolean is_tuned = false;
    private boolean is_negotiated = false;    
    
    public Car() {                
    }
    
    public void tune_car(){
        
        if (!is_tuned){
            price *= 1.25;
            max_speed *= 1.35;
            is_tuned = true;            
            System.out.println("\nTHERE! \n\n" +
                    "Now you have a faster car, but the price have " +
                    "gone up! \n");
        }
        else {
            System.out.println("This car is tuned already!");
        }
    }
    
    public void negotiate_price(){
        
        if (!is_negotiated){
            price *= 0.88;
            is_negotiated = true;           
        }
        else {
            System.out.println("The price is non-negotiable! (you greedy bastard!)");
        }       
    }
    
    /* Print car's properties */
    public void print_car() {
        System.out.printf("%10s %20s %14s \n", model, max_speed, price);
    }
    
    
    
}
