package racingCar.domain;

import java.util.Random;

public class RandomMovementGenerator implements MovementGenerator {
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MIN_MOVABLE_NUMBER = 4;

    @Override
    public boolean generate() {
        return generateNumber() >= MIN_MOVABLE_NUMBER;
    }

    @Override
    public int generateNumber() {
        Random random = new Random();
        return random.nextInt(MAX_RANDOM_NUMBER) + 1;
    }
}
