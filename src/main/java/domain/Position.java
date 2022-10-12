package domain;

import java.util.Objects;

public class Position {

    private static final int MOVING_SIZE = 1;
    private final int position;

    public Position(int position) {
        if (!isValid(position)) {
            throw new IllegalArgumentException("위치는 0 이상 이어야 합니다.");
        }
        this.position = position;
    }

    private boolean isValid(int position) {
        return position >= 0;
    }

    public int getPosition() {
        return position;
    }

    public Position movePosition() {
        return new Position(this.position + 1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Position comparePosition = (Position) obj;
        return position == comparePosition.position;
    }
}
