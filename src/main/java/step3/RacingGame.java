package step3;

import step3.car.Car;

import java.util.List;

public class RacingGame {

    public void start(List<Car> cars) {
        cars.forEach(Car::tryMove);
    }
}
