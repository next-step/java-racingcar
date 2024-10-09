package racingGame.model.car;

import racingGame.model.strategy.MovementStrategy;

public class Car {

    private static final int MIN_POSITION_VALUE = 0;
    private static final String MIN_POSITION_ERROR_MESSAGE = "위치는 최소 0 이상 입력 해주세요!";

    private int position;

    public Car() {
        this(0);
    }

    public Car(int position) {
        validatePosition(position);
        this.position = position;
    }

    private void validatePosition(int position) {
        if (position < MIN_POSITION_VALUE) {
            throw new IllegalArgumentException(MIN_POSITION_ERROR_MESSAGE);
        }
    }

    public Car clone() {
        return new Car(this.position);
    }

    public int getPosition() {
        return this.position;
    }

    public void move() {
        this.position++;
    }
}
