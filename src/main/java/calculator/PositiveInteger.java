package calculator;

import java.util.Objects;

public class PositiveInteger {

    private final int number;

    public PositiveInteger(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수를 전달할 수 없습니다.");
        }
        this.number = number;
    }

    public static PositiveInteger from(String value) {
        return new PositiveInteger(Integer.parseInt(value));
    }

    public PositiveInteger plus(PositiveInteger num) {
        return new PositiveInteger(this.number + num.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositiveInteger that = (PositiveInteger) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "PositiveInteger{" +
                "number=" + number +
                '}';
    }

}
