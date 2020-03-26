package carRacing.Domain;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Vehicles {

    List<Vehicle> vehicles;

    private Vehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public static Vehicles create(List<Vehicle> vehicles) {
        return new Vehicles(vehicles);
    }

    public Vehicles move() {
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }
        return create(vehicles);
    }

    private int winnerPosition() {
        int max = 0;
        for (Vehicle vehicle : vehicles) {
            max = vehicle.greaterThen(max);
        }
        return max;
    }

    public List<String> findWinner() {
        int max = winnerPosition();
        return vehicles.stream().filter(v -> {
            return v.inquiryPosition() >= max;
        }).map(Vehicle::getName).collect(Collectors.toList());
    }

    public List<Vehicle> getVehicles() {
        return Collections.unmodifiableList(vehicles);
    }
}
