package stage4.domain;

import java.util.Objects;

public class Position {
    private int position;

    public Position() {
        this.position = 0;
    }

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("위치는 음수일 수 없습니다");
        }
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }

    public void forward() {
        this.position++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    public boolean greaterThan(Position position) {
        return this.position > position.position;
    }
}
