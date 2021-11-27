package racingcar.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public void play() {
        cars.forEach((Car car) -> car.run(new RandomMoveStrategy()));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> getWinners() {
        Car winner = Collections.max(cars);
        return cars.stream()
                .filter((Car car) -> car.isSamePosition(winner))
                .collect(Collectors.toList());
    }
}
