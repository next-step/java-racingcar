package RacingCarV2.model;

import java.util.List;
import java.util.stream.Collectors;

public class StageResult {
    private List<Car> cars;
    private int stage;


    public StageResult(List<Car> cars) {
        this.cars = cars
                .stream()
                .map(car -> new Car(car.getName(), car.getPosition()))
                .collect(Collectors.toList());
    }

    public StageResult(List<Car> cars, int stage) {
        this.cars = cars;
        this.stage = stage;
    }

    public List<Car> getCars() {
        return cars;
    }
}
