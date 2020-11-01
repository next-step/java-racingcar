package racingcar.domain;

import racingcar.util.JavaUtilRandom;
import racingcar.util.RandomUtil;

import java.util.function.Consumer;

public class RacingCar {
    public static final int AVAILABLE_MAX_NAME_LENGTH = 5;
    private static final int RANDOM_BOUND = 10;
    private static final int MIN_MOVABLE_NUM = 4;

    private final RandomUtil randomUtil;
    private final String name;
    private int moveCount;

    public RacingCar(String name) {
        this(JavaUtilRandom.getInstance(), name);
    }

    public RacingCar(RandomUtil randomUtil, String name) {
        validateName(name);
        this.randomUtil = randomUtil;
        this.name = name;
        moveCount = 0;
    }

    private void validateName(String name) {
        if (name.length() > AVAILABLE_MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("Length of RacingCar name cannot exceed " + AVAILABLE_MAX_NAME_LENGTH);
        }
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

    public void labelName(Consumer<String> consumer) {
        consumer.accept(name);
    }

    public void repeatAsMoveCount(Runnable runnable) {
        for (int i = 0; i < moveCount; i++) {
            runnable.run();
        }
    }
}
