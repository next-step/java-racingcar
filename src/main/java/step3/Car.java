package step3;

public class Car {
    private int moveDistance;

    private static final int MOVE_CRITERION = 4;

    public Car() {
        this.moveDistance = 0;
    }

    public int getMoveDistance() {
        return moveDistance;
    }

    public void moveForward(int number) {
        if (checkProgressPossible(number)) {
            addMoveDistance();
        }
    }

    public void addMoveDistance() {
        this.moveDistance += 1;
    }

    private boolean checkProgressPossible(int number) {
        return number >= MOVE_CRITERION;
    }
}
