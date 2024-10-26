package racingcar.domain;

import java.util.Objects;

public class Position {
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public String getStatus(String symbol) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < position; i++) {
            sb.append(symbol);
        }
        return sb.toString();
    }

    public void move() {
        this.position++;
    }

    public boolean comparePosition(int position) {
        return this.position == position;
    }

    public int getMaxPosition(int prevPosition) {
        return Math.max(this.position, prevPosition);
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
}
