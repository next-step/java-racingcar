package study.racingcar;

public class Car {
    /**
     * 차량을 담당한다.
     */
    public static final String CAR_SHAPE = "-";
    public static final int MOVABLE_LOWER_BOUND = 4;
    private int moveCount = 0;

    public static boolean isMovable(int randomValue) {
        return randomValue >= MOVABLE_LOWER_BOUND;
    }

    public void move() {
        moveCount++;
    }

    @Override
    public String toString() {
        return CAR_SHAPE.repeat(moveCount);
    }
}