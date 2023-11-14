package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winner {
    private final List<Car> cars;


    public Winner(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> findWinners() {
        return calculatePosition(getMaxPosition());
    }

    public String joinWinners(List<Car> winners) {
        return winners.stream().map(Car::getName).collect(Collectors.joining(","));
    }

    private List<Car> calculatePosition(Position maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : this.cars) {
            addWinners(maxPosition, winners, car);
        }
        return winners;
    }

    private static void addWinners(Position maxPosition, List<Car> winners, Car car) {
        if (maxPosition.equals(car.getPosition())) {
            winners.add(car);
        }
    }

    private Position getMaxPosition() {
        Position maxPosition = new Position(0);
        for (Car car : this.cars) {
            maxPosition = comparePosition(maxPosition, car);
        }
        return maxPosition;
    }

    private Position comparePosition(Position maxPosition, Car car) {
        if (car.getPosition().comparePosition(maxPosition)) {
            maxPosition = car.getPosition();
        }
        return maxPosition;
    }
}
