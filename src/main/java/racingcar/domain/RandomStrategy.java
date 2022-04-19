package racingcar.domain;

import java.util.Random;

public class RandomStrategy implements RacingStrategy{

    private static final int MAX_VALUE = 10;
    private static final int BOUNDARY_VALUE= 4;
    private static final Random random = new Random();

    @Override
    public int createNumber() {
        return random.nextInt(MAX_VALUE);
    }

    @Override
    public boolean checkCondition(int randomValue) {
        if (randomValue < BOUNDARY_VALUE) {
            return false;
        }
        return true;
    }
}
