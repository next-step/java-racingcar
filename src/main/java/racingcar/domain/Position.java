package racingcar.domain;

public class Position {
    private int position;

    public Position() {}

    public Position(int position) {
        this.position = position;
    }

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }
}
