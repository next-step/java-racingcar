package step3.domain;

public class Car {
    private final static int INITIAL_POSITION = 0;
    private final static int DISTANCE_PER_MOVE = 1;
    private final static int MOVE_CRITERION = 4;
    private int position;

    public Car() {
        this.position = INITIAL_POSITION;
    }

    public int getPosition() {
        return position;
    }

    public int move(int randomNumber) {
        if (canMove(randomNumber)) {
            return position += DISTANCE_PER_MOVE;
        }
        return position;
    }

    private boolean canMove(int randomNumber) {
        return randomNumber >= MOVE_CRITERION;
    }
}
