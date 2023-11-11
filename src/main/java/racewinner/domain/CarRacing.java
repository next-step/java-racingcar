package racewinner.domain;

import racewinner.exception.InputEmptyException;
import racewinner.exception.InvalidDelimiterException;
import racewinner.exception.NegativeNumberException;
import racewinner.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {
    private final static String SPLIT_DELIMITER = ",";
    private final Cars cars;
    private int remainCount;
    private RandomGenerator generator;

    public CarRacing(String carNameList, int raceAttemptCount, RandomGenerator generator) {
        this.cars = initCars(carNameList);

        negativeNumberCheck(raceAttemptCount);
        this.remainCount = raceAttemptCount;
        this.generator = generator;
    }

    private Cars initCars(final String inputCarListName) {
        validationInput(inputCarListName);

        String[] carNameList = splitInputText(inputCarListName);

        final List<Car> cars = new ArrayList<>();
        for (String carName: carNameList) {
            cars.add(new Car(carName));
        }

        return new Cars(cars);
    }

    private String[] splitInputText(final String inputCarListName) {
        return inputCarListName.split(SPLIT_DELIMITER);
    }

    private void validationInput(final String inputCarListName) {
        if (isInputNullOrEmpty(inputCarListName)) {
            throw new InputEmptyException();
        }

        if (isInputCommaNotContain(inputCarListName)) {
            throw new InvalidDelimiterException();
        }
    }
    private boolean isInputCommaNotContain(final String inputCarListName) {
        return !inputCarListName.contains(SPLIT_DELIMITER);
    }

    private boolean isInputNullOrEmpty(final String inputCarListName) {
        return inputCarListName == null || inputCarListName.isBlank();
    }

    private void negativeNumberCheck(final int raceAttemptCount) {
        if (raceAttemptCount < 0) {
            throw new NegativeNumberException();
        }
    }

    public void race() {
        this.remainCount--;
        cars.move(generator);
    }

    public boolean isFinished() {
        return remainCount == 0;
    }

    public List<String> findWinners() {
        return cars.findWinner();
    }

    @Override
    public String toString() {
        return cars.toString();
    }
}
