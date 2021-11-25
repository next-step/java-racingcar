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

        if (splitCarNames.length != 3) {
            throw new IllegalArgumentException("자동차는 3대만 입력 가능합니다.");
        }

        return splitCarNames;
    }

    private void start() {
        int numberOfTrial = InputView.getNumberOfTrial();

        for (int i = 0; i < numberOfTrial; i++) {
            move(cars);
        }
    }

    private void move(List<Car> cars) {
        OutputView.printSeparator();

        cars.forEach(car -> {
                    RandomNumber randomNumber = new RandomNumber();
                    car.move(randomNumber.equalsOrBiggerThanCondition());

                    OutputView.printPosition(car);
                }
        );
    }

    private void finish() {
        List<Car> winners = cars.stream()
                .filter(car -> car.getPosition() == maximum())
                .collect(Collectors.toList());

        OutputView.printWinners(winners);
    }

    private int maximum() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(-1);
    }
}
