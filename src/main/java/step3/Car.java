package step3;

public class Car {
    private int position = 1;

    private static final int LIMIT_POINT_TO_MOVE = 4;

    public void run(int movePoint) {
        if (isMovable(movePoint)) {
            this.position++;
        }
    }

    public int getPosition() {
        return this.position;
    }

    private boolean isMovable(int movePoint) {
        return movePoint >= LIMIT_POINT_TO_MOVE ;
    }



}
