package racingcar.domain;

import racingcar.util.JavaUtilRandom;
import racingcar.util.RandomUtil;

public class RacingCar implements Comparable<RacingCar> {
    public static final int AVAILABLE_MAX_NAME_LENGTH = 5;
    private static final int RANDOM_BOUND = 10;
    private static final int MIN_MOVABLE_NUM = 4;

    public final String name;
    private final RandomUtil randomUtil;
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

    public void repeatAsMoveCount(Runnable runnable) {
        for (int i = 0; i < moveCount; i++) {
            runnable.run();
        }
    }

    public boolean isSameMoveCount(RacingCar racingCar) {
        return moveCount == racingCar.moveCount;
    }

    @Override
    public int compareTo(RacingCar racingCar) {
        if (moveCount == racingCar.moveCount) {
            return name.compareTo(racingCar.name);
        }
        return Integer.compare(racingCar.moveCount, moveCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RacingCar)) return false;

        RacingCar racingCar = (RacingCar) o;

        return name != null ? name.equals(racingCar.name) : racingCar.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
