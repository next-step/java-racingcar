package racingcar;

import java.util.Random;

public class MoveStrategy {

    private static final int MOVABLE_MIN_VALUE = 4;
    private static final int RANDOM_BOUND = 10;

    private int number;

    MoveStrategy(int number) {
        if (number < 0 || number > 9) {
            throw new IllegalArgumentException("0과 9 사이의 숫자가 아닙니다.");
        }
        this.number = number;
    }

    public MoveStrategy() {
        Random random = new Random();
        this.number = random.nextInt(RANDOM_BOUND);
    }

    public boolean isMovable() {
        return greaterThanMinValue(this.number);
    }

    private static boolean greaterThanMinValue(final int number) {
        return number >= MOVABLE_MIN_VALUE;
    }
}
