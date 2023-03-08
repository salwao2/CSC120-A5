import java.util.ArrayList;

/**

The Car class that can hold a certain number of passengers.
It has methods for adding and removing passengers and printing a list
of passengers currently in the car.
*/

public class Car {
    // instance variables

    /**
    * An ArrayList to store the passengers currently in the car.
    */
    private ArrayList<Passenger> passengers; // arraylist to store passengers in car

    /**
    * The maximum capacity of the car, i.e. the number of passengers it can hold.
    */
    private int maxCapacity; // maximum capacity of the car

    // constructor method

    /**
    * Constructs a Car object with the specified maximum capacity.
    * 
    * @param maxCapacity the maximum number of passengers the car can hold
    */

    public Car(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.passengers = new ArrayList<Passenger>(maxCapacity); // initialize passengers arraylist
    }

    // method to get the maximum capacity of the car

    /**
    * Returns the maximum number of passengers the car can hold.
    * 
    * @return the maximum capacity of the car
    */

    public int getCapacity() {
        return maxCapacity;
    }

    // method to get the number of seats remaining in the car
    /**
    * Returns the number of seats remaining in the car.
    * 
    * @return the number of available seats in the car
    */

    public int seatsRemaining() {
        return maxCapacity - passengers.size();
    }

    // method to add a passenger to the car

    /**
    * Adds the specified passenger to the car.
    * Throws a RuntimeException if the car is already full.
    * 
    * @param p the passenger to add to the car
    * @throws RuntimeException if the car is already full
    */

    public void addPassenger(Passenger p) {
        if (passengers.size() >= maxCapacity) { // if the car is already full
            throw new RuntimeException("Car is full"); // throw an exception
        }
        passengers.add(p); // add the passenger to the arraylist
    }

    // method to remove a passenger from the car

    /**
    * Removes the specified passenger from the car.
    * Throws a RuntimeException if the passenger is not in the car.
    * 
    * @param p the passenger to remove from the car
    * @throws RuntimeException if the passenger is not in the car
    */

    public void removePassenger(Passenger p) {
        if (!passengers.contains(p)) { // if the passenger is not in the car
            throw new RuntimeException("Passenger not found in car"); // throw an exception
        }
        passengers.remove(p); // remove the passenger from the arraylist
    }

    // method to print the list of passengers in the car

    /**
     * Prints a list of the passengers currently in the car.
     * If the car is empty, it prints a message indicating so.
     */

    public void printManifest() {
        if (passengers.isEmpty()) { // if there are no passengers in the car
            System.out.println("This car is EMPTY.");
        } else { // if there are passengers in the car
            System.out.println("Passengers aboard:");
            for (Passenger p : passengers) { // loop through each passenger in the arraylist
                System.out.println("- " + p.getName()); // print the passenger's name
            }
        }
    }

    public static void main(String[] args) {
        // Create a car with a maximum capacity of 3 passengers
        Car car = new Car(3);
    
        // Create some passengers
        Passenger harry = new Passenger("Harry");
        Passenger hermione = new Passenger("Hermione");
        Passenger ron = new Passenger("Ron");
    
        // Add some passengers to the car
        car.addPassenger(harry);
        car.addPassenger(hermione);
        car.addPassenger(ron);
    
        // Print the current manifest
        System.out.println("Current manifest:");
        car.printManifest();
    
        // Try to add another passenger (should throw an exception)
        try {
            car.addPassenger(new Passenger("Ginny"));
        } catch (RuntimeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    
        // Remove a passenger from the car
        car.removePassenger(harry);
    
        // Print the updated manifest
        System.out.println("Updated manifest:");
        car.printManifest();
    
        // Try to remove a passenger that is not in the car (should throw an exception)
        try {
            car.removePassenger(new Passenger("Luna"));
        } catch (RuntimeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
    
}