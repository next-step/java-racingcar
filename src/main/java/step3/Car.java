package step3;

public class Car {
    int moveNumber = 0;
    private static final int VERIFY_START_MOVE_NUMBER = 4;
    private static final int VERIFY_END_MOVE_NUMBER = 9;
    private static final int MOVE_NUMBER = 1;

    public void move(int moveNumber) {
        if (moveNumber >= VERIFY_START_MOVE_NUMBER && moveNumber <= VERIFY_END_MOVE_NUMBER) {
            this.moveNumber += MOVE_NUMBER;
        }
    }

    public int getMoveNumber() {
        return this.moveNumber;
    }
}
