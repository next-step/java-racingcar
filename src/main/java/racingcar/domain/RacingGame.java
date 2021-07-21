package racingcar.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {

    private List<Car> cars;
    private Random random = new Random();

    private RacingGame() {

    }

    public RacingGame(int numberOfCars) {
        this.cars = initialize(numberOfCars);
    }

    public List<Car> start() {
        move();
        return cars;
    }

    private List<Car> initialize(int numberOfCars) {
        return IntStream.range(0, numberOfCars)
                .mapToObj(i -> new Car())
                .collect(Collectors.toList());
    }

    private void move() {
        for (Car car : this.cars) {
            car.move(this.random.nextInt(10));
        }
    }
}
