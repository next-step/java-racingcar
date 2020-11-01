package racingcar.domain;

import racingcar.util.JavaUtilRandom;
import racingcar.util.RandomUtil;

public class RacingCar {
    private static final int RANDOM_BOUND = 10;
    private static final int MIN_MOVABLE_NUM = 4;

    private final RandomUtil randomUtil;
    private final String name;
    private int moveCount;

    public RacingCar(String name) {
        this.randomUtil = JavaUtilRandom.getInstance();
        this.name = name;
        moveCount = 0;
    }

    public RacingCar(RandomUtil randomUtil, String name) {
        this.randomUtil = randomUtil;
        this.name = name;
        moveCount = 0;
    }

    public void tryToMove() {
        if (isMovable()) {
            moveCount++;
        }
    }

    private boolean isMovable() {
        int randomNumber = randomUtil.getInt(RANDOM_BOUND);
        return randomNumber >= MIN_MOVABLE_NUM;
    }

    public void repeatAsMoveCount(Runnable runnable) {
        for (int i = 0; i < moveCount; i++) {
            runnable.run();
        }
    }
}
