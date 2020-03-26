package carRacing.Domain;

import java.util.ArrayList;
import java.util.List;


public class RacingGame {

    int numberOfVehicle;

    VehicleType vehicleType;

    public RacingGame(int numberOfCar, VehicleType vehicleType) {
        this.numberOfVehicle = numberOfCar;
        this.vehicleType = vehicleType;
    }

    public List<Vehicle> registerVehicles(MoveStrategy moveStrategy) {
        List<Vehicle> racingVehicles = new ArrayList<>();
        for (int i = 0; i < numberOfVehicle; i++) {
            racingVehicles.add(vehicleType.init(moveStrategy));
        }
        return racingVehicles;
    }

    public List<Vehicle> rotate(List<Vehicle> vehicles) {
        List<Vehicle> racingVehicles = new ArrayList<>(vehicles);
        for (Vehicle vehicle : racingVehicles) {
            vehicle.move();
        }
        return racingVehicles;
    }
}
