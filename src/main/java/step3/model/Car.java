package step3.model;

public class Car {
    private int position = 0;
    public static final int MOVE_OR_STOP_VALUE = 4;

    public void move(int movePoint) {
        if (isMove(movePoint)) {
            this.position++;
        }
    }

    public boolean isMove(int movePoint) {
        return movePoint >= MOVE_OR_STOP_VALUE;
    }

    public int getPosition() {
        return position;
    }
}
