package calculator;

import java.util.Objects;

/**
 * 피연산자 래퍼 클래스
 */
public class Number {
    private final int value;

    private Number(int value) {
        this.value = value;
    }

    private Number(String value) {
        this(Integer.parseInt(value));
    }

    public static Number of(String value) {
        return new Number(value);
    }

    public static Number of(int value) {
        return new Number(value);
    }

    public int toInt() {
        return value;
    }

    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
