package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    public List<Car> findWinners(List<Car> raceResult) {
        return calculatePosition(getMaxPosition(raceResult), raceResult);
    }

    private List<Car> calculatePosition(Position maxPosition, List<Car> raceResult) {
        List<Car> winners = new ArrayList<>();
        for (Car car : raceResult) {
            addWinners(maxPosition, winners, car);
        }
        return winners;
    }

    private static void addWinners(Position maxPosition, List<Car> winners, Car car) {
        if (maxPosition.equals(car.getPosition())) {
            winners.add(car);
        }
    }

    private Position getMaxPosition(List<Car> raceResult) {
        Position maxPosition = new Position(0);
        for (Car car : raceResult) {
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
