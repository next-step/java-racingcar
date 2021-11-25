package study;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    public static final String DELIMITER = ",";

    private List<Car> cars;

    public void run() {
        setup();
        start();
        finish();
    }

    private void setup() {
        cars = Arrays.stream(splitCarNames())
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private String[] splitCarNames() {
        String carNames = InputView.getCarNames();
        String[] splitCarNames = carNames.split(DELIMITER);

        for (String name : splitCarNames) {
            cars.forEach(car -> car.name(name));
        }
    }

    private void start() {
        int numberOfTrial = InputView.getNumberOfTrial();

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
