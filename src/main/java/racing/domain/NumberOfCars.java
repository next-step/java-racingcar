package racing.domain;

import java.util.Objects;

public class NumberOfCars {
    private final int number;

    private NumberOfCars(final int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수가 될 수 없습니다.");
        }
        this.number = number;
    }

    public static NumberOfCars of(final int number) {
        return new NumberOfCars(number);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        final NumberOfCars that = (NumberOfCars) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
