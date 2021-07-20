package racinggame;

public class Car {

    private static final int MOVABLE_NUMBER = 4;
    private int position;

    public Car() {
        this.position = 0;
    }

    public boolean race(int num) {
        boolean movable = isMovable(num);
        if (movable) {
            position++;
        }
        return movable;
    }

    public int getPosition() {
        return position;
    }

    private boolean isMovable(int num) {
        return num >= MOVABLE_NUMBER;
    }
}
