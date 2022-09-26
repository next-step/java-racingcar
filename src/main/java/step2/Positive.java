package step2;

import java.util.Objects;

public class Positive {

    private final int value;
    public static final Positive ZERO = new Positive(0);

    public Positive(String text) {
        this(toInt(text));
    }

    public Positive(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
        this.value = value;
    }

    public Positive plus(Positive number) {
        return new Positive(this.value + number.value);
    }

    private static int toInt(String text) {
        return Integer.parseInt(text);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Positive positive = (Positive) o;
        return value == positive.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
