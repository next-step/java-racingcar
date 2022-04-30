package racing.domain;

import racing.domain.exception.MaxNumberException;
import racing.domain.exception.NegativeNumberException;

import java.util.Objects;

public class Position {
    private static final int MAX_NUMBER = 9;
    private static final int MIN_NUMBER = 0;

    private int position;

    public Position() {
        this(0);
    }

    public Position(String position) {
        this(Integer.parseInt(position));
    }

    public Position(int position) {
        validate(position);
        this.position = position;
    }

    private void validate(int position) {
        if (position < MIN_NUMBER) {
            throw new NegativeNumberException();
        }
        if (position > MAX_NUMBER) {
            throw new MaxNumberException();
        }
    }

    public void move() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }

    public boolean isMaxPosition(int position) {
        return this.position >= position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }


    @Override
    public String toString() {
        return "-".repeat(this.position);
    }

}
