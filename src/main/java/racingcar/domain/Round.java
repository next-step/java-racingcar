package racingcar.domain;

import java.util.Objects;

public final class Round {

    private static final String NOT_POSITIVE_MESSAGE = "라운드는 0 이하가 될 수 없습니다.";

    private int value;

    private Round(final int value) {
        validate(value);
        this.value = value;
    }

    public static Round from(final int round) {
        return new Round(round);
    }

    public int getValue() {
        return value;
    }

    public void decrease() {
        validate(this.value);
        this.value--;
    }

    private static void validate(final int round) {
        if (round <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_MESSAGE);
        }
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
