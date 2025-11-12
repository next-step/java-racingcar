package study.racing.domain;

import java.util.Objects;

public class RoundCount {
    private static final int MIN_ROUND = 1;
    private final int value;

    public RoundCount(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if(value < MIN_ROUND) {
            throw new IllegalArgumentException("게임 라운드는 1회 이상이여야 합니다.");
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RoundCount that = (RoundCount) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "RoundCount{value= " + value + "}";
    }
}
