
public class Passenger {
    private String name;

    // Constructor takes a name parameter then initializes the passenger's name

    /**
     * Constructor that initializes the passenger's name.
     * @param name The name of the passenger
     */

    public Passenger(String name) {
        this.name = name;
    }

    // Returns the passenger's name

     /**
     * Returns the name of the passenger.
     * @return The name of the passenger
     */

    public String getName() {
        return name;
    }

    // Add the passenger to the given car, printing a boarded message if successful or an error message if not

    /**
     * Adds the passenger to the given car, printing a message if successful or an error message if not.
     * @param c The car to add the passenger to
     */

    public void boardCar(Car c) {
        try {
            c.addPassenger(this);
            System.out.println(this.getName() + " boarded car.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    // Removes the passenger from the given car, printing a got off car message if successful or an error message if not

    /**
     * Removes the passenger from the given car, printing a message if successful or an error message if not.
     * @param c The car to remove the passenger from
     */

    public void getOffCar(Car c) {
        try {
            c.removePassenger(this);
            System.out.println(this.getName() + " got off car.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

        public static void main(String[] args) {
            // Create a new car with a max capacity of 2
            Car car = new Car(2);
    
            // Create two new passengers
            Passenger p1 = new Passenger("Harry");
            Passenger p2 = new Passenger("Hermione");
    
            // Have both passengers board the car
            p1.boardCar(car);
            p2.boardCar(car);
    
            // Try to board a third passenger, which should throw an exception
            Passenger p3 = new Passenger("Ron");
            p3.boardCar(car);
    
            // Have one of the passengers get off the car
            p1.getOffCar(car);
    
            // Have the first passenger try to get off the car again, which should throw an exception
            p1.getOffCar(car);
    
            // Print the passenger manifest for the car
            car.printManifest();
        }
    
    }
    


    


