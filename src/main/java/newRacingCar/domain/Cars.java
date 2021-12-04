package newRacingCar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> findWinners() {
        List<Car> winners = new ArrayList<>();
        Position maxPosition = maxPositionCar();
        for (Car car : cars) {
            if (car.getPosition().isSamePosition(maxPosition)) {
                winners.add(car);
            }
        }
        return winners;
    }

    public Position maxPositionCar() {
        Position position = new Position(0);
        for (Car car : cars) {
            if (position.isMaxPosition(car.getPosition())) {
                position = car.getPosition();
            }
        }
        return position;
    }
}