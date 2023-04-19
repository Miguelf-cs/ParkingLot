/**
 * @author - Miguel Ferreiro 
 * COP-3337 
 * NetBeans IDE 8.2
 * Java 1.8.0_221
 * Instructor - Dr. Charlyne Walker
 * 
 * The New Valet class will keep track of cars using a parking lot, street and  
 * waiting queue. We will use stacks and queues to solve the problem.
*/
//package project7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class NewValet 
{
    // Implementing the data structures for the appropriate groups
    Stack<Integer> parkingLot  = new Stack<>() ;
    Stack<Integer> streetLot  = new Stack<>() ;
    Queue<Integer> carsWaiting  = new LinkedList<>() ;
        
    // Adding a car to the lot
    public void addCar(int plate)
    {
        // Keep in mind a max of 20 cars only fit in the new valet lot
        if( parkingLot.size() < 20 )
        {
            parkingLot.push(plate) ;
        }else
        {
            carsWaiting.add(plate) ;
        }
        
        // Update data info
        System.out.println("Parking lot updated after " + plate + " was added: ") ;
        System.out.println(parkingLot) ;
        System.out.println("Cars in queue: " + carsWaiting) ;
    }
    
    //Removing a car from the lot and updating the waiting queue
    public void removeCar(int plate)
    {
        if( parkingLot.empty() )
        {
            System.out.println("The parking lot is empty!") ;
        }else
        {
            // If lot isnt empty then we must move one by one the cars to the street
            // Until correct license plat is found
            int temp = parkingLot.pop() ;
            
            while( temp != -plate )
            {
                streetLot.push(temp) ;
                
                if(parkingLot.empty())
                {
                    break;
                }
                
                temp = parkingLot.pop() ;
            }
            
            // Move cars back to lot
            while( !streetLot.empty() )
            {
                parkingLot.push(streetLot.pop()) ;
            }
            
            //Update car queue waiting to get in
            if( parkingLot.size() < 20 && !carsWaiting.isEmpty() ) //FIXXXX 
            {
                 parkingLot.push(carsWaiting.remove()) ;
            }
        }
        // Update data info
        System.out.println("Parking lot updated after " + -plate + " was removed: ") ;
        System.out.println(parkingLot) ;
        System.out.println("Cars in queue: " + carsWaiting) ;
    }
    
}
