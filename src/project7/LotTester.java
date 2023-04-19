/**
 * @author - Miguel Ferreiro 
 * COP-3337 
 * NetBeans IDE 8.2
 * Java 1.8.0_221
 * Instructor - Dr. Charlyne Walker
 * 
 * The Lot Tester class will keep track of cars using a parking lot. 
 * We will use stacks and queues to solve the problem.
*/
//package project7;

import java.util.Scanner;

public class LotTester 
{

    public static void main(String[] args) 
    {    
        NewValet valet = new NewValet() ;
        Scanner driver = new Scanner(System.in) ;
        System.out.println("Welcome to FIU's newest valet parking lot!" + "\n" +
                           "Before we get started does your car have the special decal?" +
                            "\n" + "Type 1 for YES or type 2 for NO");
        
        int choice = driver.nextInt();
        
        if(choice == 1)
        {
            System.out.println("Awesome. Please enter your license plate number in order " 
                + "to add your car to the parking lot." + "\n" + "Enter your license "
                + "plate number with a negative sign in front to retrieve your car." + "\n" 
                + "PLEASE NOTE your car will be placed in a queue if the parking lot is full!!! " 
                + "Type 0 only if you wish to exit this menu") ;
        
            choice = driver.nextInt() ;
      
            while( choice != 0 )
            {
                if( choice > 0 )
                {
                    valet.addCar(choice) ;
                }else
                {
                    valet.removeCar(choice) ;
                }
               
                choice = driver.nextInt() ;
            }
        }else
        {
            System.out.println("Sorry you are not allowed here without your car having one"
                               + "\n" + "GOODBYE") ;
        }
        
        
    }
    
}
