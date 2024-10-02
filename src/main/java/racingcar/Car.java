package racingcar;

public class Car {
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 9;
    public static final int MOVABLE_VALUE = 4;

    private int moveCount;

    public void move(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException("Only accepts integers between 0 and 9: " + value);
        }
        if (value >= MOVABLE_VALUE) moveCount++;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
