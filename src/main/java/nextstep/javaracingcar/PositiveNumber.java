package nextstep.javaracingcar;

import java.util.function.IntConsumer;

public class PositiveNumber implements Comparable<PositiveNumber> {
    private final int number;

    public static final PositiveNumber ZERO = new PositiveNumber(0);
    public static final PositiveNumber ONE = new PositiveNumber(1);

    private PositiveNumber(final int value) {
        if (value < 0) {
            throw new RuntimeException("음수 값은 처리할 수 없습니다.");
        }
        this.number = value;
    }

    public static PositiveNumber from(final int value) {
        return new PositiveNumber(value);
    }

    public static PositiveNumber from(final String value) {
        return from(Integer.parseInt(value));
    }

    public PositiveNumber plus(final PositiveNumber other) {return new PositiveNumber(this.number + other.number);
    }
    public PositiveNumber decrease() {
        if(this.number == 0) {
            throw new IllegalStateException("0 은 감소할 수 없습니다.");
        }
        return new PositiveNumber(this.number - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PositiveNumber positiveNumber = (PositiveNumber) o;

        return number == positiveNumber.number;
    }

    @Override
    public int compareTo(final PositiveNumber other) {
        return Integer.compare(this.number, other.number);
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public String toString() {
        return "Positive{" + "number=" + number + '}';
    }

    public void loop(final IntConsumer consumer) {
        for (int i = 0; i < this.number; i++) {
            consumer.accept(i);
        }
    }
}
