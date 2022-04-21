package racingcar;

import java.util.Objects;

public class Position {

    private int at;

    public Position(int i) {
        if ( i < 0 ) throw new IllegalArgumentException("Position should be more than 1");
        this.at = i;
    }

    public Position(String s) {
        this(Integer.parseInt(s));
    }

    public Position() {
        this(1);
    }

    @Override
    public String toString() {
        return "Position{" +
                "at=" + at +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return at == position.at;
    }

    @Override
    public int hashCode() {
        return Objects.hash(at);
    }

    public void move() {
        this.at = this.at + 1;
    }

    public String createTrack() {
        return "-".repeat(this.at);
    }

    public int compareMax(int max) {
        if (this.at > max) return this.at;
        return max;
    }

    public boolean isMaxPosition(int max) {
            return this.at == max;
    }
}
