package racingCar.domain;

import java.util.Objects;

public class Position implements Comparable<Position> {
    private int cur = 0;

    public int getPosition() {
        return cur;
    }

    public void move() {
            this.cur++;
    }

    @Override
    public int compareTo(Position o) {
        if(this.cur == o.cur) {
            return 0;
        }
        if(this.cur < o.cur) {
            return -1;
        }
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return cur == position.cur;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cur);
    }
}
