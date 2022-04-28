package racingcar.domain;

import java.util.Random;

public class RandomStrategy implements RacingStrategy {

    private static final int MAX_VALUE = 10;
    private static final int BOUNDARY_VALUE = 4;
    private static final Random random = new Random();

    @Override
    public boolean checkCondition() {
        return random.nextInt(MAX_VALUE) >= BOUNDARY_VALUE;
    }

}
