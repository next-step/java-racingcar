package racingcar.domain;

import java.util.Random;
import racingcar.domain.RandomCarMovingCondition.RandomGenerator;

public class TimeBaseRandomGenerator implements RandomGenerator {

    private final Random random = new Random();

    @Override
    public int nextInt(int bound) {
        return random.nextInt(bound);
    }
}
