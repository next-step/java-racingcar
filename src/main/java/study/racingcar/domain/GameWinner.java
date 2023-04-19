package study.racingcar.domain;

import study.racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class GameWinner {

    private int maxPosition;
    private List<Car> cars;

    public GameWinner(List<Car> cars) {
        this.maxPosition = getMaxPosition(cars);
        this.cars = cars;
    }

    public int getMaxPosition(List<Car> carList) {

        return carList.stream()
                .map(Car::currentPosition)
                .max(Integer::compareTo)
                .orElse(0);
    }

    public List<String> findGameWinner() {

        return cars.stream()
                .filter(car -> car.isPosition(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
