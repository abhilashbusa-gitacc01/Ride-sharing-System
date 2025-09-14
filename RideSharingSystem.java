```java
import java.util.Scanner;

/**
 * Exception thrown when an invalid ride type is specified.
 */
class InvalidRideTypeException extends Exception {
    /**
     * Constructs a new InvalidRideTypeException with the specified detail message.
     *
     * @param message the detail message.
     */
    public InvalidRideTypeException(String message) {
        super(message);
    }
}

/**
 * Abstract class representing a generic ride.
 */
abstract class Ride {
    /**
     * The name of the driver.
     */
    private String driverName;

    /**
     * The vehicle number.
     */
    private String vehicleNumber;

    /**
     * The distance of the ride in kilometers.
     */
    protected double distance;

    /**
     * Constructs a new Ride with the specified driver name, vehicle number, and distance.
     *
     * @param driverName   the name of the driver.
     * @param vehicleNumber the vehicle number.
     * @param distance     the distance of the ride in kilometers.
     */
    public Ride(String driverName, String vehicleNumber, double distance) {
        this.driverName = driverName;
        this.vehicleNumber = vehicleNumber;
        this.distance = distance;
    }

    /**
     * Returns the name of the driver.
     *
     * @return the driver's name.
     */
    public String getDriverName() {
        return driverName;
    }

    /**
     * Returns the vehicle number.
     *
     * @return the vehicle number.
     */
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    /**
     * Returns the distance of the ride.
     *
     * @return the distance in kilometers.
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Calculates the fare for the ride.
     *
     * @return the fare amount.
     */
    public abstract double calculateFare();
}

/**
 * Class representing a bike ride.
 */
class BikeRide extends Ride {
    /**
     * Constructs a new BikeRide with the specified driver name, vehicle number, and distance.
     *
     * @param driverName   the name of the driver.
     * @param vehicleNumber the vehicle number.
     * @param distance     the distance of the ride in kilometers.
     */
    public BikeRide(String driverName, String vehicleNumber, double distance) {
        super(driverName, vehicleNumber, distance);
    }

    /**
     * Calculates the fare for the bike ride.
     *
     * @return the fare amount, calculated as distance × 10.
     */
    @Override
    public double calculateFare() {
        return distance * 10; // fare = distance × 10
    }
}

/**
 * Class representing a car ride.
 */
class CarRide extends Ride {
    /**
     * Constructs a new CarRide with the specified driver name, vehicle number, and distance.
     *
     * @param driverName   the name of the driver.
     * @param vehicleNumber the vehicle number.
     * @param distance     the distance of the ride in kilometers.
     */
    public CarRide(String driverName, String vehicleNumber, double distance) {
        super(driverName, vehicleNumber, distance);
    }

    /**
     * Calculates the fare for the car ride.
     *
     * @return the fare amount, calculated as distance × 20.
     */
    @Override
    public double calculateFare() {
        return distance * 20; // fare = distance × 20
    }
}

/**
 * Main class for the Ride Sharing System.
 */
public class RideSharingSystem {
    /**
     * Main method to run the Ride Sharing System.
     *
     * @param args command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Read ride type and distance from user input
            String rideType = sc.nextLine().trim().toLowerCase();
            double distance = sc.nextDouble();

            // Validate distance
            if (distance <= 0) {
                throw new IllegalArgumentException("Distance must be greater than 0");
            }

            Ride ride;

            // Determine ride type and create corresponding ride object
            if (rideType.equals("bike")) {
                ride = new BikeRide("Raju", "AP39AB1234", distance);
            } else if (rideType.equals("car")) {
                ride = new CarRide("Suresh", "AP39CD5678", distance);
            } else {
                throw new InvalidRideTypeException("Invalid ride type entered: " + rideType);
            }

            // Display ride details and fare
            System.out.println("Driver: " + ride.getDriverName());
            System.out.println("Vehicle No: " + ride.getVehicleNumber());
            System.out.println("Distance: " + ride.getDistance() + " km");
            System.out.println("Fare: ₹" + ride.calculateFare());

        } catch (InvalidRideTypeException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
```