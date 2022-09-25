package racing;

public class Car {

    private static final int BOUND = 10;
    private static final int MOVABLE_LIMIT = 4;

    private final RandomNumber random;
    private int position;

    public Car(RandomNumber random) {
        this.position = 1;
        this.random = random;
    }

    public void move() {
        if (isMovable()) {
            moveForward();
        }
    }

    public int currentPosition() {
        return position;
    }

    private boolean isMovable() {
        return random.generate(BOUND) >= MOVABLE_LIMIT;
    }

    private void moveForward() {
        position++;
    }
}
