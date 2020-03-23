package racingcar.domain;

import racingcar.domain.car.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingScore {
    private final List<Car> cars;

    public RacingScore(List<Car> cars) {
        this.cars = Collections.unmodifiableList(cars);
    }

    public List<Car> getScore() {
        return new ArrayList<>(cars);
    }

    public List<Car> getWinner() {
        int maxPosition = calculateMaxPosition();
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            addWinner(maxPosition, winners, car);
        }

        return new ArrayList<>(winners);
    }

    private void addWinner(int maxPosition, List<Car> winners, Car car) {
        if (car.isWinner(maxPosition)) {
            winners.add(car);
        }
    }

    private int calculateMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }
}
