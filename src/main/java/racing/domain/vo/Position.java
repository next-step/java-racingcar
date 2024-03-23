package racing.domain.vo;

import java.util.Objects;

public class Position {

    private static final int MIN_AVAILABLE_CHANCE = 4;
    private int number;

    public Position() {
        this(0);
    }

    public Position(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public void movePosition(int chance){
        if (chance >= MIN_AVAILABLE_CHANCE){
            this.number++;
        }
    }

    public Position maxPosition(Position other) {
        if (other.number > number) {
            return other;
        }
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return number == position.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
