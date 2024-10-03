package racingcar.domain;

import racingcar.util.NumberGenerator;

public class Car {
    private static final int MIN_MOVABLE_CONDITION_NUMBER = 4;
    private static final int INITIAL_CAR_POSITION = 0;
    private final NumberGenerator numberGenerator;

    private int position = 0;

    public Car(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        this.position = INITIAL_CAR_POSITION;
    }

    public void move() {
        if (determineMovable()) {
            position++;
        }
    }

    private boolean determineMovable() {
        int randomNumber = numberGenerator.generate();
        return randomNumber >= MIN_MOVABLE_CONDITION_NUMBER;
    }

    public int getPosition() {
        return position;
    }
}
