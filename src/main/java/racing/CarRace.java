package racing;

import java.util.List;

public class CarRace {
    private final List<Car> cars;

    public CarRace(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("car is empty");
        }
        this.cars = cars;
    }

    public void round() {
        cars.forEach(Car::tryMove);
    }
}
