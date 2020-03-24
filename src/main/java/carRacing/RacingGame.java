package carRacing;

import org.assertj.core.util.VisibleForTesting;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    int numberOfVehicle;
    int time;

    List<Vehicle> vehicles;
    RacingObserver observe;

    public RacingGame(int numberOfCar, int time) {
        this.numberOfVehicle = numberOfCar;
        this.time = time;
        vehicles = setVehicles();
        observe = new RacingObserver(vehicles);
    }

    public List<Vehicle> setVehicles() {
        List<Vehicle> prepareVehicles = new ArrayList<>();
        for (int i = 0; i < numberOfVehicle; i++) {
            prepareVehicles.add(new Car());
        }
        return prepareVehicles;
    }

    public void start(MoveStrategy moveStrategy) {
        for (int i = 0; i < time; i++) {
            rotate(moveStrategy);
            observe.tracking(vehicles);
        }
    }

    private void rotate(MoveStrategy moveStrategy) {
        for (Vehicle vehicle : vehicles) {
            vehicle.move(moveStrategy);
        }
    }

    @VisibleForTesting
    public List<Integer> observe() {
        return observe.observe(vehicles);
    }

}
