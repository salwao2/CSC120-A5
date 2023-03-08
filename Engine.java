
/**
 * An engine with information about its fuel type and fuel level.
 */

public class Engine {

    // Storing the engine's fuel type and fuel level information

    /** The fuel type of the engine. */
    private FuelType fuelType;
    /** The current fuel level of the engine. */
    private double currentFuelLevel;
    /** The maximum fuel level of the engine. */
    private double maxFuelLevel;

    // Constructor that initializes the fuel type and fuel level 

    /**
     * Constructs a new Engine object with the specified fuel type and fuel levels.
     * 
     * @param fuelType the fuel type of the engine
     * @param currentFuelLevel the current fuel level of the engine
     * @param maxFuelLevel the maximum fuel level of the engine
     */

    public Engine(FuelType fuelType, double currentFuelLevel, double maxFuelLevel) {
        this.fuelType = fuelType;
        this.currentFuelLevel = currentFuelLevel;
        this.maxFuelLevel = maxFuelLevel;
    }

    // Getter method to retrieve the engine's fuel type

    /**
     * Retrieves the fuel type of the engine.
     * 
     * @return the fuel type of the engine
     */

    public FuelType getFuelType() {
        return fuelType;
    }

    // Getter method to retrieve the current fuel level of the engine

    /**
     * Retrieves the current fuel level of the engine.
     * 
     * @return the current fuel level of the engine
     */

    public double getCurrentFuelLevel() {
        return currentFuelLevel;
    }

    // Getter method to retrieve the maximum fuel level of the engine

    /**
     * Retrieves the maximum fuel level of the engine.
     * 
     * @return the maximum fuel level of the engine
     */

    public double getMaxFuelLevel() {
        return maxFuelLevel;
    }

    // Method to refuel the engine, setting the current fuel level to the maximum level

    /**
     * Refuels the engine by setting the current fuel level to the maximum fuel level.
     */

    public void refuel() {
        currentFuelLevel = maxFuelLevel;
    }

    // Method to start the engine and decrease the fuel level by one unit
    public void go() {
        if (currentFuelLevel == 0) { 
            throw new RuntimeException("Out of fuel"); // If there is no fuel left, throw an exception
        }

        // Decrease the fuel level and print the remaining fuel level
        currentFuelLevel--;
        System.out.println("Remaining fuel level: " + currentFuelLevel);
    }

    
    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 50.0, 100.0);
        try {
            while (true) {
                myEngine.go();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage()); // Out of fuel
        }
        
        // Test getFuelType()
        System.out.println("Fuel type: " + myEngine.getFuelType()); // Expected output: DIESEL
    
        // Test getCurrentFuelLevel()
        System.out.println("Current fuel level: " + myEngine.getCurrentFuelLevel()); // Expected output: 50.0
    
        // Test getMaxFuelLevel()
        System.out.println("Max fuel level: " + myEngine.getMaxFuelLevel()); // Expected output: 100.0
    
        // Test refuel()
        myEngine.refuel();
        System.out.println("Current fuel level after refueling: " + myEngine.getCurrentFuelLevel()); // Expected output: 100.0
    
        // Test go()
        myEngine.go();
        System.out.println("Remaining fuel level after one go: " + myEngine.getCurrentFuelLevel()); // Expected output: 99.0
    }


}

