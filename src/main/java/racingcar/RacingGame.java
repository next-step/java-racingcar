package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {

    private List<Car> cars = new ArrayList<>();
    private Random random = new Random();

    public RacingGame() {

    }

    public void start(final String carInput, final String attemptInput) {

        final int numberOfCars = parseInt(carInput);
        final int numberOfAttempts = parseInt(attemptInput);

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

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 값은 정수 여야 합니다.");
        }
    }

    private void move() {
        for (Car car : this.cars) {
            car.move(this.random.nextInt(10));
        }
    }

    private void print() {
        this.cars.forEach(c -> System.out.println(c.getProgressBar()));
        System.out.println();
    }
}
