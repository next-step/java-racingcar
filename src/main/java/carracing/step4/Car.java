package carracing.step4;

public class Car {
    private static final int MOVABLE_THRESHOLD = 4;
    private final String name;
    private int moveCount;

    public Car(String name) {
        this.name = name;
        this.moveCount = 0;
    }

    public void move(int moveNumber) {
        if (isMovable(moveNumber)) {
            moveCount += 1;
        }
    }

    private boolean isMovable(int moveNumber) {
        return moveNumber >= MOVABLE_THRESHOLD;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

}
