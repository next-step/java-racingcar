package racingcar.racing;

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
        return cars.toString();
    }
}