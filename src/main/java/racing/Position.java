package racing;

import java.util.Objects;

public class Position {
    private int position;

    Position(String position) {
        this(Integer.parseInt(position));
    }

    Position(int position) {
        if (isNegativeNumber(position)) {
            throw new IllegalArgumentException("음수를 입력할 수 없습니다.");
        }
        this.position = position;
    }

    private boolean isNegativeNumber(int position) {
        return position < 0;
    }

    void move(int randomNo) {
        this.position += randomNo;
    }

    boolean isMaxPosition(int maxPosition) {
        return this.position == maxPosition;
    }

    int maxPosition(int maxPosition) {
        if (maxPosition < this.position) {
            return this.position;
        }
        return maxPosition;
    }

    int getPosition() {
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
}
