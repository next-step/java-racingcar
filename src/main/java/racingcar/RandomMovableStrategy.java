package racingcar;

import racingcar.domain.Car;

import java.util.Random;

public final class RandomMovableStrategy implements MovableStrategy {

    private static final String NOT_VALID_RANGE_MESSAGE = "범위 밖의 수가 입력되었습니다.";
    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 9;

    private static final Random random = new Random();

    @Override
    public boolean isMove() {
        final int number = getNumber();

        if (isStoppableNumber(number)) {
            return false;
        } else if (isMovableNumber(number)) {
            return true;
        }
        throw new IllegalArgumentException(NOT_VALID_RANGE_MESSAGE);
    }

    private static int getNumber() {
        return random.nextInt(UPPER_BOUND - LOWER_BOUND + 1);
    }

    private static boolean isStoppableNumber(int number) {
        return number >= LOWER_BOUND && number <= Car.MOVE_UPPER_BOUND;
    }

    private static boolean isMovableNumber(int number) {
        return number >= Car.MOVE_UPPER_BOUND + 1 && number <= UPPER_BOUND;
    }
}
