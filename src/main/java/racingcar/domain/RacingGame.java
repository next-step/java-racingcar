package racingcar.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingGame {

    private List<Car> cars;
    private Random random = new Random();

    public RacingGame(List<String> names) {
        this.cars = initialize(names);
    }

    public List<Car> start() {
        move();
        return cars;
    }

    private List<Car> initialize(List<String> names) {
        return names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void move() {
        for (Car car : this.cars) {
            car.move(this.random.nextInt(10));
        }
    }
}
