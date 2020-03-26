package carRacing;

import carRacing.domain.MoveStrategy;
import carRacing.domain.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    int numberOfVehicle;

    VehicleType vehicleType;
    List<Vehicle> racingVehicles;

    public RacingGame(int numberOfCar, VehicleType vehicleType) {
        this.numberOfVehicle = numberOfCar;
        this.vehicleType = vehicleType;
        this.racingVehicles = new ArrayList<>();
    }

    public List<Vehicle> registerVehicles(MoveStrategy moveStrategy) {
        for (int i = 0; i < numberOfVehicle; i++) {
            racingVehicles.add(vehicleType.init(moveStrategy));
        }
        return racingVehicles;
    }

    public List<Vehicle> start(int time) {
        for (int i = 0; i < time; i++) {
            rotate();
        }
        return racingVehicles;
    }

    private void rotate() {
        for (Vehicle vehicle : racingVehicles) {
            vehicle.move();
        }
    }

    List<Integer> observe() {
        List<Integer> positions = new ArrayList<>();

        int i = positions.size();
        for (Vehicle vehicle : racingVehicles) {
            positions.add(i++, vehicle.inquiryPosition());
        }
        return positions;
    }
}
