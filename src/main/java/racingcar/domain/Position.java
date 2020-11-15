package racingcar.domain;

import java.util.Objects;

public class Position {
    private final int position;

    public Position(final int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public String getPositionString() {
        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < this.position; index++) {
            sb.append('-');
        }
        return sb.toString();
    }

    public int greaterThan(int maxPosition) {
        if (this.position > maxPosition) {
            return this.position;
        }
        return maxPosition;
    }

    public boolean isMaxPosition(int maxPosition) {
        return this.position == maxPosition;
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
