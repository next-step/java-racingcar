package carRacing;

import carRacing.domain.MoveStrategy;
import carRacing.domain.Vehicle;
import org.assertj.core.util.VisibleForTesting;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    int numberOfVehicle;

    List<Vehicle> vehicles;
    RacingObserver observe;

    public RacingGame(int numberOfCar, VehicleType vehicleType, MoveStrategy moveStrategy) {
        this.numberOfVehicle = numberOfCar;
        vehicles = setVehicles(vehicleType, moveStrategy);
        observe = new RacingObserver(vehicles);
    }

    public List<Vehicle> setVehicles(VehicleType vehicleType, MoveStrategy moveStrategy) {
        List<Vehicle> prepareVehicles = new ArrayList<>();
        for (int i = 0; i < numberOfVehicle; i++) {
            prepareVehicles.add(vehicleType.init(moveStrategy));
        }
        return prepareVehicles;
    }

    public void start(int time) {
        for (int i = 0; i < time; i++) {
            rotate();
            observe.tracking(vehicles);
        }
    }

    private void rotate() {
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }
    }

    @VisibleForTesting
    public List<Integer> observe() {
        return observe.observe(vehicles);
    }

}
