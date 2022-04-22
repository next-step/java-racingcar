package racing.domain;

import java.util.Objects;

public class NormalMove implements MovingStrategy {
    private final int number;

    public NormalMove(int number) {
        this.number = number;
    }

    @Override
    public boolean movable() {
        return this.number >= 4 && this.number <= 9;
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
