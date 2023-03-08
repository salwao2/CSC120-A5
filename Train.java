import java.util.ArrayList;

/**
 * A train with an engine and multiple cars.
 */

public class Train {
    /** The Engine object for the train. */
    private final Engine engine; // An Engine object for the train
    /** The ArrayList of Car objects for the train's cars. */
    private final ArrayList<Car> cars; // An ArrayList of Car objects for the train's cars

    // Constructor

    /**
     * Creates a new Train object with the specified fuel type, fuel capacity, number of cars, and passenger capacity.
     * @param fuelType the fuel type for the train's engine
     * @param fuelCapacity the fuel capacity for the train's engine
     * @param nCars the number of cars for the train
     * @param passengerCapacity the passenger capacity for each car
     */

    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity) {
        // Create an Engine object for the train with the specified fuel type and capacity
        // Set the initial fuel level to be equal to the fuel capacity
        this.engine = new Engine(fuelType, fuelCapacity, fuelCapacity);
        // Create an ArrayList of Car objects for the train's cars
        this.cars = new ArrayList<Car>();
        // Add nCars number of Car objects with specified passenger capacity to the cars ArrayList
        for (int i = 0; i < nCars; i++) {
            cars.add(new Car(passengerCapacity));
        }
    }    

    // Getter method for engine

    /**
     * Returns the Engine object for the train.
     * @return the Engine object for the train
     */

    public Engine getEngine() {
        return engine;
    }

    // Getter method for specific car at given index

    /**
     * Returns the Car object at the specified index.
     * @param i the index of the Car object to return
     * @return the Car object at the specified index
     */

    public Car getCar(int i) {
        return cars.get(i);
    }

    // Method to get maximum capacity of the train

    /**
     * Returns the maximum capacity of the train, which is the sum of the passenger capacities of all the cars.
     * @return the maximum capacity of the train
     */

    public int getMaxCapacity() {
        int maxCapacity = 0;
        // Iterate over all the cars in the train and sum their individual capacities
        for (Car car : cars) {
            maxCapacity += car.getCapacity();
        }
        return maxCapacity;
    }

    // Method to get remaining number of seats in the train

    /**
     * Returns the remaining number of seats in the train, which is the sum of the remaining seats in all the cars.
     * @return the remaining number of seats in the train
     */

    public int seatsRemaining() {
        int seatsRemaining = 0;
        // Iterate over all the cars in the train and sum their individual remaining seats
        for (Car car : cars) {
            seatsRemaining += car.seatsRemaining();
        }
        return seatsRemaining;
    }

    // Method to print the manifest of the train's cars and their passengers

    /**
     * Prints the manifest of the train's cars and their passengers.
     */

    public void printManifest() {
        boolean emptyTrain = true;
        // Iterate over all the cars in the train and print their manifest
        for (int i = 0; i < cars.size(); i++) {
            System.out.println("Car " + (i+1) + ":");
            Car car = cars.get(i);
            if (car.seatsRemaining() == car.getCapacity()) { // If the car is empty, print "This car is EMPTY." 

                System.out.println("This car is EMPTY.");
            } else {
                car.printManifest(); // Otherwise, print the car's passengers
                emptyTrain = false;
            }
        }

        // If the train is empty, print "This train is EMPTY."
        if (emptyTrain) {
            System.out.println("This train is EMPTY.");
        }
    }


    public static void main(String[] args) {
        Train train = new Train(FuelType.ELECTRIC, 50.0, 3, 4);
        
        // test getEngine() method
        Engine engine = train.getEngine();
        System.out.println("Engine fuel type: " + engine.getFuelType());
        
        // test getCar() method
        Car car1 = train.getCar(0);
        System.out.println("Car 1 capacity: " + car1.getCapacity());
        
        // test getMaxCapacity() method
        System.out.println("Maximum total capacity: " + train.getMaxCapacity());
        
        // test seatsRemaining() method
        System.out.println("Seats remaining: " + train.seatsRemaining());
        
        // test printManifest() method
        train.printManifest();
        
        // add some passengers to the train
        Passenger p1 = new Passenger("Harry");
        Passenger p2 = new Passenger("Ron");
        Passenger p3 = new Passenger("Hermione");
        
        p1.boardCar(car1); // should work
        p2.boardCar(car1); // should work
        p3.boardCar(car1); // should throw RuntimeException because car is full
        
        train.printManifest(); // should print list of passengers in car1
    }
    
}

