package step4.domain;

import step4.strategy.MovableStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(final List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("경주를 진행할 자동차가 존재하지 않습니다.");
        }
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(Car.from(name));
        }
        return new Cars(cars);
    }

    public void move(MovableStrategy strategy) {
        for (Car car : cars) {
            car.move(strategy);
        }
    }

    public List<String> getWinnerNames() {
        Position winnerPosition = getWinnerPosition();
        return cars.stream().filter(car -> car.isWinner(winnerPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private Position getWinnerPosition() {
        int winnerPosition = 0;
        for (Car car : cars) {
            winnerPosition = Math.max(car.getPosition(), winnerPosition);
        }
        return new Position(winnerPosition);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
