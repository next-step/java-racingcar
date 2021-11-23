package study;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Car> cars = new ArrayList<>();

    public void run() {
        setup();
        start();
        finish();
    }

    private void setup() {
        int numberOfCars = InputView.numberOfCars();

        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }
    }

    private void start() {
        int numberOfTrial = InputView.numberOfTrial();

        for (int i = 0; i < numberOfTrial; i++) {
            move(cars);
        }
    }

    private void move(List<Car> cars) {
        cars.forEach(car -> {
                    RandomNumber randomNumber = new RandomNumber();
                    car.move(randomNumber.equalsOrBiggerThanCondition());
                }
        );
    }

    private void finish() {
        for (Car car : cars) {
            OutputView.print(car.getPosition());
        }
    }
}
