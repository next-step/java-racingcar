package racingcar.domain;

import racingcar.behavior.MovingStrategy;
import racingcar.util.ErrorMessage;

public class Car {
    static final int DEFAULT_DISTANCE = 0;
    private static final int MAX_INPUT_NAME_VALUE = 5;
    private static final String BLANK = " ";

    private int position;
    private final String carName;

    public Car(String carName) {
        this.position = DEFAULT_DISTANCE;
        this.carName = validateNamesOfCars(carName);
    }

    public static String validateNamesOfCars(String carName) {
        if (isNullOrEmpty(carName) || isFiveLetterWords(carName)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NAME_ERROR);
        }
        return carName;
    }

    static boolean isNullOrEmpty(String carName) {
        return carName.trim().isEmpty() || carName.equals(BLANK);
    }

    static boolean isFiveLetterWords(String carName) {
        return carName.trim().length() > MAX_INPUT_NAME_VALUE;
    }

    public void move(final MovingStrategy movingStrategy) {
        if (movingStrategy.isMovable()) {
            position++;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public boolean hasSamePosition(int position) {
        return this.position == position;
    }

    public String getCarName() {
        return this.carName;
    }
}