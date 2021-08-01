package Car;

public class Car {
    private static final int MIN_MOVE_NUMBER = 4;

    private int moveCount;

    public Car() {
        moveCount = 0;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void move(int inputNumber) {
        if (inputNumber >= MIN_MOVE_NUMBER) {
            moveCount++;
        }
    }
}
