package Racing.car;

import Racing.stage.Stage;
import Racing.type.RacingString;

import java.util.List;

public class CarList {

    private final List<Car> cars;

    public CarList(List<Car> cars) {
        this.cars = cars;
    }

    public CarList moveAllCar(Stage stage) {
        this.cars.
                forEach(car -> car.move(stage));
        return this;
    }

    public RacingString displayCarDistance() {
        return this.cars.stream()
                .map(Car::presentDistance)
                .collect(RacingString.joining(RacingString.DELIMITER));
    }

}
