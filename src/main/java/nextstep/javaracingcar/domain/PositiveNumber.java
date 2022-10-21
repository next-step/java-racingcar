package nextstep.javaracingcar.domain;

import java.util.Iterator;

public class PositiveNumber implements Iterable<Integer> {
    private final int number;

    private PositiveNumber(final int value) {
        if (value < 0) {
            throw new RuntimeException("음수 값은 처리할 수 없습니다.");
        }
        this.number = value;
    }

    public static PositiveNumber from(final int value) {
        return new PositiveNumber(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PositiveNumber positiveNumber = (PositiveNumber) o;

        return number == positiveNumber.number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public String toString() {
        return "Positive{" + "number=" + number + '}';
    }

    @Override
    public Iterator<Integer> iterator() {
        return new SizeIterator(number);
    }
}
