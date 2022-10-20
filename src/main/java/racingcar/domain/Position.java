package racingcar.domain;

public class Position {
    private int position = 0;

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
