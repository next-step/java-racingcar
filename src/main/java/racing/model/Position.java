package racing.model;

import exception.InvalidPositionException;

public class Position {
    private static final int INITIAL_POSITION = 0;
    private int position;

    public Position() {
        this(INITIAL_POSITION);
    }

    public Position(int position) {
        if (position < INITIAL_POSITION) {
            throw new InvalidPositionException("자동차 위치는 음수가 될 수 없습니다.");
        }
        this.position = position;
    }

    public boolean isMaxPosition(int maxPosition) {
        return this.position == maxPosition;
    }

    public void move() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }
}
