package step2;

public class Car {
    private final static int INITIAL_POSITION = 0;
    private final static int DISTANCE_PER_MOVE = 1;

    private int position;

    public Car() {
        this.position = INITIAL_POSITION;
    }

    public int getPosition() {
        return this.position;
    }

    public int move() {
        return this.position += DISTANCE_PER_MOVE;
    }
}
