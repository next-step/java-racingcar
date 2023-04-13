package study;

public class RacingCar {
    private int moveCount = 0;
    private static final int MOVE_BOUNDARY = 4;

    public void moveOrStop(int randomNumber) {
        if (canMoveForward(randomNumber)) {
            moveForward();
        }
    }

    public int getMoveCount() {
        return this.moveCount;
    }

    private boolean canMoveForward(int number) {
        if (number >= MOVE_BOUNDARY) {
            return true;
        }
        return false;
    }

    private void moveForward() {
        this.moveCount++;
    }
}
