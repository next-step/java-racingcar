package racingcar;

import racingcar.domain.Car;

import java.util.Random;

public final class RandomMovableStrategy implements MovableStrategy {

    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 9;

    private static final Random random = new Random();

    @Override
    public boolean isMove() {
        final int number = getNumber();
        return !isStoppableNumber(number);
    }

    private static int getNumber() {
        return random.nextInt(UPPER_BOUND - LOWER_BOUND + 1);
    }

    private static boolean isStoppableNumber(int number) {
        return number >= LOWER_BOUND && number <= Car.MOVE_UPPER_BOUND;
    }
}
