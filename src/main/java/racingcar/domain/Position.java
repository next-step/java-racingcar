package racingcar.domain;

public class Position {
    private static final int STOP_POSITION = 0;
    private int position = 0;

    public int getPosition() {
        return this.position;
    }

    public void add() {
        this.position++;
    }

    public boolean isMoved() {
        return position != STOP_POSITION;
    }

    public boolean isStop() {
        return position == STOP_POSITION;
    }
}
