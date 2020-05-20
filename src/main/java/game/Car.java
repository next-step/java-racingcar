package game;

public class Car {
    private int position;
    private final MovePolicy movePolicy;

    private static final int MOVING_RANGE = 1;

    public Car(int position, MovePolicy movePolicy) {
        this.position = position;
        this.movePolicy = movePolicy;
    }

    public void move() {
        if (movePolicy.isMovable()) {
            position += MOVING_RANGE;
        }
    }

    public int getPosition() {
        return position;
    }
}
