package step33;

public class Car {
    public static final int POSSIBLE_MOVE_NUMBER = 3;

    private int moveCount;

    public void moveCars(int number) {
        if (number > POSSIBLE_MOVE_NUMBER) {
            moveCount++;
        }
    }

    public int getMoveCount() {
        return moveCount;
    }
}
