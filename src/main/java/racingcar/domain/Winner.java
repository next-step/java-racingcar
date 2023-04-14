package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private final Cars cars;

    public Winner(Cars cars) {
        this.cars = cars;
    }

    private Position winnerPosition() {
        return cars.highPosition();
    }

    public List<Car> winnerCars() {
        List<Car> winnerCars = new ArrayList<>();
        for (Car car : cars.cars()) {
            this.addWinner(car, winnerCars);
        }

        return winnerCars;
    }

    private void addWinner(Car car, List<Car> cars) {
        Position winnerPosition = winnerPosition();
        if (winnerPosition.equals(car.position())) {
            cars.add(car);
        }
    }
}
