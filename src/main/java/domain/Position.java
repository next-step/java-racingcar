package domain;

import java.util.Objects;

public class Position {

    private final int position;

    public Position(int position) {
        if (!gameEnd(position)) {
            throw new IllegalArgumentException("위치는 0 이상 이어야 합니다.");
        }
        this.position = position;
    }

    private boolean gameEnd(int position) {
        return position >= 0;
    }

    public int getPosition() {
        return position;
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
