package racingcar.domain;

import racingcar.strategy.MovingStrategy;
import racingcar.ui.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }
    public Cars(String[] names) {
        this.cars = Arrays.stream(names)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void moveAll(MovingStrategy strategy) {
        cars.forEach(car -> car.move(strategy));
    }

    public List<Car> getCurrentStatus() {
        return Collections.unmodifiableList(cars);
    }

    public List<String> getWinners() {
        int maxMoveCount = cars.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getMoveCount() == maxMoveCount)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
