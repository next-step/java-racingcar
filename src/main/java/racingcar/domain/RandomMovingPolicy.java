package racingcar.domain;

import java.util.concurrent.ThreadLocalRandom;

public class RandomMovingPolicy implements MovingPolicy {
    private static final Integer MIN_NUM = 0;
    private static final Integer MAX_NUM = 10;
    private static final Integer MOVABLE_BOUNDARY = 4;

    @Override
    public Integer nextStep() {
        if (randomNumber() >= MOVABLE_BOUNDARY) {
            return 1;
        }
        return 0;
    }

    Integer randomNumber() {
        return ThreadLocalRandom.current().nextInt(MIN_NUM, MAX_NUM);
    }
}
