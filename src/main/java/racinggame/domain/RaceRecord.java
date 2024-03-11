package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RaceRecord {

    private final List<Car> cars;

    public RaceRecord(List<Car> cars) {

        this.cars = cars.stream().map(Car::copy).collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinners() {
        return getWinners(getWinnerPosition());
    }

    private Position getWinnerPosition() {
        Position winnerPosition = new Position();
        for (Car car : cars) {
            winnerPosition = comparePosition(winnerPosition, car);
        }
        return winnerPosition;
    }

    private Position comparePosition(Position winnerPosition, Car car) {
        if (winnerPosition.compareTo(car.position()) < 0) {
            return car.position();
        }
        return winnerPosition;
    }

    private List<Car> getWinners(Position winnerPosition) {
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.position().compareTo(winnerPosition) == 0) {
                winners.add(car);
            }
        }
        return winners;
    }
}
