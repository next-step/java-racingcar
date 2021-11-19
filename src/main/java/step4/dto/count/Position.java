package step4.dto.count;

import step4.common.Number;

public class Position {
    private int position;

    public Position() {
        this.position = Number.ZERO.getValue();
    }

    public Position(int input) {
        this.position = input;
    }

    public Position(Position other) {
        this.position = other.position;
    }

    public void plusPosition() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }

    public boolean isMaxPosition(Position other) {
        return this.position >= other.position;
    }

    public Position maxPosition() {
        return new Position(this.position);
    }
}
