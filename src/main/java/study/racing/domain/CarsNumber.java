package study.racing.domain;

import java.util.Objects;

public class CarsNumber {

    private static final int MIN_NUMBER = 2;
    private final int value;

    public CarsNumber(String value) {

        int number = parseCarsNumber(value);
        if (number < MIN_NUMBER) {
            throw new IllegalArgumentException("자동차 대수는 2 이상 이어야 합니다.");
        }
        this.value = number;
    }

    private int parseCarsNumber(String value) {

        int number;
        try {
            number = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("자동차 대수는 숫자여야 합니다.");
        }
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarsNumber that = (CarsNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
