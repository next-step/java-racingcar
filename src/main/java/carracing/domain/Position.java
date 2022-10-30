package carracing.domain;

import java.util.Objects;
import java.util.stream.IntStream;

public class Position {

    private int position;

    public Position(){
        this(0);
    }

    public Position(String position) {
        this(Integer.parseInt(position));
    }

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("0이상의 값만 유효합니다.");
        }
        this.position = position;
    }

    public Position increase() {
        this.position = position+1;
        return this;
    }

    public boolean checkHasPosition(int position) {
        return this.position == position;
    }

    public int getBiggerPosition(int position) {
        if (position < this.position) {
            return this.position;
        }
        return position;
    }

    public int getPosition() {
        return this.position;
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
        return "Position{" +
                "position=" + position +
                '}';
    }

}
