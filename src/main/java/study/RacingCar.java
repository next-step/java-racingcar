package study;

public class RacingCar {
    private int moveCount = 0;

    public void moveOrStop(int randomNumber) {
        if (MoveChecker.canMoveForward(randomNumber)) {
            moveForward();
        }
    }

    public int getMoveCount() {
        return this.moveCount;
    }


    private void moveForward() {
        this.moveCount++;
    }
}
