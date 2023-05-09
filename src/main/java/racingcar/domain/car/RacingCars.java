package racingcar.domain.car;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public Position maxLocation() {
        Position max = new Position();

        for (Car car : cars) {
            max = car.maxLocation(max);
        }

        return max;
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> findCarsAt(Position position) {
        List<Car> cars = new ArrayList<>();

        for (Car car : this.cars) {
            if (car.isAt(position)) {
                cars.add(car);
            }
        }

        return cars;
    }

    public List<Car> all() {
        return new ArrayList<>(this.cars);
    }
}
