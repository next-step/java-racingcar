package racing.domain;

import java.util.Objects;

public class NumberOfRound {
    private final int number;

    private NumberOfRound(final int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수가 될 수 없습니다.");
        }
        this.number = number;
    }

    public static NumberOfRound of(final int number) {
        return new NumberOfRound(number);
    }

    public NumberOfRound decrease() {
        if (this.number - 1 < 0) {
            return new NumberOfRound(0);
        }
        return new NumberOfRound(this.number - 1);
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        final NumberOfRound that = (NumberOfRound) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
