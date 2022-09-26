package carracing.step4;

public class Car {
    private static final int MOVABLE_THRESHOLD = 4;
    private final String name;
    private int moveCnt;

    public Car(String name) {
        this.name = name;
        this.moveCnt = 0;
    }

    public void move(int moveNumber) {
        if (isMovable(moveNumber)) {
            moveCnt += 1;
        }
    }

    private boolean isMovable(int moveNumber) {
        return moveNumber >= MOVABLE_THRESHOLD;
    }

    public String getName() {
        return name;
    }

    public int getMoveCnt() {
        return moveCnt;
    }

}
