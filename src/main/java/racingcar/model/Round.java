package racingcar.model;

import java.util.Objects;

public class Round {
    private static final String INPUT_COUNT_ERROR_MESSAGE = "0 이상의 수를 입력해주세요.";

    private final int value;

    public Round(int value) {
        this.value = value;
    }

    public static Round create(int value) {
        validate(value);
        return new Round(value);
    }

    public Round decrease() {
        return new Round(this.value - 1);
    }

    public int getValue() {
        return value;
    }

    public boolean checkRound() {
        return value != 0;
    }

    private static int validate(int value) {
        if (value <= 0) {
            throw new IllegalStateException(INPUT_COUNT_ERROR_MESSAGE);
        }
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round = (Round) o;
        return value == round.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
