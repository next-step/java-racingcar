package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {

    private List<Car> cars = new ArrayList<>();

    public RacingGame() {

    }

    public void start(int numberOfCars, int numberOfAttempts) {
        this.cars = initialize(numberOfCars);
        for (int i = 0; i < numberOfAttempts; i++) {
            move();
            print();
        }
    }

    private List<Car> initialize(int numberOfCars) {
        return IntStream.range(0, numberOfCars)
                .mapToObj(i -> new Car())
                .collect(Collectors.toList());
    }

    private void move() {
        this.cars.forEach(Car::move);
    }

    public void print() {
        this.cars.forEach(Car::print);
        System.out.println();
    }
}
