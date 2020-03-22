package racingcar.domain;

import java.util.Random;

public class RandomCondition {
    private final Random random = new Random();

    public int getRandomCondition() {
        return random.nextInt(RacingGameConstant.RANDOM_LIMIT);
    }
}
