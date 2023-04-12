package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private final Cars cars;
    public Winner(Cars cars) {
        this.cars = cars;
    }

    private Position winnerPosition() {
        Position position = Position.init();

        for (Car car : cars.cars()) {
            position = this.highPosition(position, car.position());
        }

        return position;
    }

    private Position highPosition(Position winnerPosition, Position position) {
        if (position.compareTo(winnerPosition) > 0) {
            return position;
        }

        return winnerPosition;
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
