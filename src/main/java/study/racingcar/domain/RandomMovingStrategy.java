package study.racingcar.domain;

import java.util.Random;

public class RandomMovingStrategy implements CarMovingStrategy {

    private static final Random RANDOM = new Random();

    private static final int LOWER_LIMIT_TO_MOVE_CAR = 4;
    private static final int UPPER_LIMIT_TO_MOVE_CAR = 10;

    public int getRandomNumber() {
        return RANDOM.nextInt(UPPER_LIMIT_TO_MOVE_CAR);
    }

    @Override
    public boolean canMoveCar() {
        if (getRandomNumber() >= LOWER_LIMIT_TO_MOVE_CAR) {
            return true;
        }
        return false;
    }
}
