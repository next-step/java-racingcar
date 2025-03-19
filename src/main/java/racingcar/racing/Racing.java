package racingcar.racing;

import racingcar.car.Car;

import java.util.List;

public class Racing {
    private final List<Car> cars;

    public Racing(List<Car> cars) {
        this.cars = cars;
    }

    public void playRound() {
        cars.forEach(Car::play);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        cars.forEach(car -> {
            result.append("-".repeat(Math.max(0, car.getDistance())));
            result.append("\n");
        });
        return result.toString();
    }
}