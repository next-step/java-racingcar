package carracing.step3;

public class Car {
    private int moveCnt;
    private static final int MOVABLE_THRESHOLD = 4;

    public void move(int moveNumber) {
        if (isMovable(moveNumber)) {
            moveCnt += 1;
        }
    }

    private boolean isMovable(int moveNumber) {
        return moveNumber >= MOVABLE_THRESHOLD;
    }

    public String moveTrace() {
        return "-".repeat(Math.max(0, moveCnt));
    }

}
