package study.racingcar;

import java.util.Random;

public class Car {
    /**
     * 차량을 담당한다.
     */
    public static final String CAR_SHAPE = "-";
    private final Random random = new Random();
    private int moveCount = 0;

    public void move() {
        int randomValue = random.nextInt(10);
        if (randomValue >= 4) {
            moveCount++;
        }
    }

    @Override
    public String toString() {
        return CAR_SHAPE.repeat(moveCount);
    }
}