package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private List<Car> cars;

    public RacingGame(List<String> names) {
        this.cars = initialize(names);
    }

    public List<Car> start() {
        move();
        return cars;
    }

    private List<Car> initialize(final List<String> names) {
        return names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void move() {
        for (Car car : this.cars) {
            car.move((int) (Math.random() * 10));
        }
    }
}
