package calculator;

import java.util.Objects;

public class NonNegative {
    private final int value;

    public NonNegative(String value) {
        this(Integer.parseInt(value));
    }

    public NonNegative(int value) {
        if (value < 0) {
            throw new RuntimeException("음수를 입력할 수 없습니다.");
        }
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public NonNegative plus(int that) {
        return new NonNegative(this.value + that);
    }

    public NonNegative plus(NonNegative that) {
        return plus(that.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NonNegative that = (NonNegative) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "NonNegative{" +
                "value=" + value +
                '}';
    }
}
