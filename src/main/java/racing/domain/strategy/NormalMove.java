package racing.domain.strategy;

import java.util.Objects;

public class NormalMove implements MovingStrategy {
    private static final int BEGIN_MOVE_NUMBER = 4;
    private static final int END_MOVE_NUMBER = 9;
    private final int number;

    public NormalMove(int number) {
        this.number = number;
    }

    @Override
    public boolean movable() {
        return this.number >= BEGIN_MOVE_NUMBER && this.number <= END_MOVE_NUMBER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NormalMove that = (NormalMove) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "NormalMove{" +
                "number=" + number +
                '}';
    }
}
