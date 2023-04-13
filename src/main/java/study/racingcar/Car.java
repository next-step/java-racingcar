package study.racingcar;

import java.util.Random;

public class Car {
    /**
     * 차량을 담당한다.
     */
    public static final String CAR_SHAPE = "-";
    public static final int RANDOM_BOUND_NUMBER = 10;
    public static final int MOVABLE_LOWER_BOUND = 4;
    private final Random random = new Random();
    private int moveCount = 0;

    public void move() {
        int randomValue = random.nextInt(RANDOM_BOUND_NUMBER);
        if (randomValue >= MOVABLE_LOWER_BOUND) {
            moveCount++;
        }
    }

    public void move(int randomValue) {
        if (randomValue >= MOVABLE_LOWER_BOUND) {
            moveCount++;
        }
    }

    @Override
    public String toString() {
        return CAR_SHAPE.repeat(moveCount);
    }
}