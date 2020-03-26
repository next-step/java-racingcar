package racingcar.domain;

import racingcar.domain.car.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = Collections.unmodifiableList(cars);
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public List<Car> findWinners() {
        int maxPosition = calculateMaxPosition();
        List<Car> winners = cars.stream()
                .filter(car -> car.isWinner(maxPosition))
                .collect(Collectors.toList());
        return new ArrayList<>(winners);
    }

    private int calculateMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }
}
