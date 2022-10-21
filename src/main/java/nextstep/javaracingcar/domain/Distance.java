package nextstep.javaracingcar.domain;

public class Distance implements Comparable<Distance> {
    public static final Distance ZERO = new Distance(0);
    public static final Distance ONE = new Distance(1);
    private final int value;

    public Distance(final int value) {
        if (value < 0) {
            throw new RuntimeException("음수 값은 처리할 수 없습니다.");
        }
        this.value = value;
    }

    public Distance plus(final Distance other) {
        return new Distance(this.value + other.value);
    }

    public Iterable<Integer> toIterable() {
        return () -> new SizeIterator(value);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Distance distance = (Distance) o;

        return value == distance.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public int compareTo(final Distance o) {
        return Integer.compare(this.value, o.value);
    }

    @Override
    public String toString() {
        return "Distance{" +
                "value=" + value +
                '}';
    }
}
