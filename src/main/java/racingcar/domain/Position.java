package racingcar.domain;

import java.util.Objects;

public class Position implements Comparable<Position> {
    private Integer position;

    public Position(int position) {
        assertValidRange(position);
        this.position = position;
    }

    public Integer getPosition() {
        return position;
    }

    public void move(MoveType moveType) {
        int positionAfterMove = position + moveType.getMovePosition();
        assertValidRange(positionAfterMove);
        position = positionAfterMove;
    }

    private void assertValidRange(int position) {
        String errorMessage = "[Position] 음수는 허용되지 않습니다,";
        if (position < 0) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            throw new IllegalArgumentException();
        }
        if (this == o) {
            return true;
        }

        Position target = (Position) o;
        return this.position.equals(target.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public int compareTo(Position o) {
        if (o == null || getClass() != o.getClass()) {
            throw new IllegalArgumentException();
        }
        if (this == o) {
            return 0;
        }

        return this.position.compareTo(o.position);
    }
}
