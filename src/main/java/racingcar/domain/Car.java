package racingcar.domain;

import racingcar.util.NumberGenerator;
import racingcar.util.RandomNumberGenerator;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private int position;

    public Car() {
        this(0);
    }

    public Car(int position) {
        validatePositive(position);
        this.position = position;
    }

    private void validatePositive(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("position은 0 이상이어야 합니다. position:" + position);
        }
    }

    public int move(NumberGenerator numberGenerator) {
        if (isMovable(numberGenerator)) incrementPosition();
        return position;
    }

    private boolean isMovable(NumberGenerator numberGenerator) {
        return numberGenerator.generate() >= MOVE_THRESHOLD;
    }

    private void incrementPosition() {
        position++;
    }

}