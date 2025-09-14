import java.util.Scanner;


class InvalidRideTypeException extends Exception {
    public InvalidRideTypeException(String message) {
        super(message);
    }
}


abstract class Ride {
    private String driverName;
    private String vehicleNumber;
    protected double distance;  

    public Ride(String driverName, String vehicleNumber, double distance) {
        this.driverName = driverName;
        this.vehicleNumber = vehicleNumber;
        this.distance = distance;
    }

    
    public String getDriverName() {
        return driverName;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public double getDistance() {
        return distance;
    }

    
    public abstract double calculateFare();
}


class BikeRide extends Ride {
    public BikeRide(String driverName, String vehicleNumber, double distance) {
        super(driverName, vehicleNumber, distance);
    }

    @Override
    public double calculateFare() {
        return distance * 10; // fare = distance × 10
    }
}

class CarRide extends Ride {
    public CarRide(String driverName, String vehicleNumber, double distance) {
        super(driverName, vehicleNumber, distance);
    }

    @Override
    public double calculateFare() {
        return distance * 20; // fare = distance × 20
    }
}


public class RideSharingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
        
            String rideType = sc.nextLine().trim().toLowerCase();
            double distance = sc.nextDouble();

            if (distance <= 0) {
                throw new IllegalArgumentException("Distance must be greater than 0");
            }

            Ride ride;
            
            if (rideType.equals("bike")) {
                ride = new BikeRide("Raju", "AP39AB1234", distance);
            } else if (rideType.equals("car")) {
                ride = new CarRide("Suresh", "AP39CD5678", distance);
            } else {
                throw new InvalidRideTypeException("Invalid ride type entered: " + rideType);
            }

            
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