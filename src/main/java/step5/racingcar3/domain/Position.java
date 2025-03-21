package step5.racingcar3.domain;

import step5.racingcar3.exception.PositionException;

public class Position {

    public static final int MIN_POSITION = 0;
    private int value;

    public Position() {
        this(MIN_POSITION);
    }

    public Position(int value) {
        validate(value);
        this.value = value;
    }

    public void increase() {
        value++;
    }

    public int value() {
        return value;
    }

    private void validate(int value) {
        if (value < MIN_POSITION) {
            throw new PositionException("위치는 0 이상의 정수만 가능합니다.");
        }
    }

}
