package racingcar;

import java.util.Objects;

public class Position {
    private final int position;

    public Position(int position) {
        validatePosition(position);
        this.position = position;
    }

    public Position(Position posToBeCopied) {
        this.position = posToBeCopied.position;
    }

    public Position increase() {
        return new Position(position+1);
    }

    private void validatePosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("자동차의 위치는 0 이상의 정수여야합니다.");
        }
    }

    public int getPosition(){
        return position;
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
