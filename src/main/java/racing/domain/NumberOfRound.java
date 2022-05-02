package racing.domain;

import java.util.Objects;

import racing.exception.GameException;

public class NumberOfRound {
    private static final int FINAL_ROUND = 1;
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
        if (isLeftRound()) {
            return new NumberOfRound(this.number - 1);
        }
        throw new GameException("모든 Round가 종료되었습니다.");
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

    public boolean isLeftRound() {
        return this.number >= FINAL_ROUND;
    }
}
