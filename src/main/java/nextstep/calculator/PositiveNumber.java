package nextstep.calculator;

public class PositiveNumber {
    private final int number;

    public static final PositiveNumber ZERO = new PositiveNumber(0);

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

    public PositiveNumber plus(PositiveNumber one) {
        return new PositiveNumber(this.number + one.number);
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
}
