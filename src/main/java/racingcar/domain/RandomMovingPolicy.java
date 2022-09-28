package racingcar.domain;

import racingcar.controller.RandomGenerator;

public class RandomMovingPolicy implements MovingPolicy {
    private static final Integer MOVABLE_BOUNDARY = 4;

    private final RandomGenerator randomGenerator;

    public RandomMovingPolicy(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    @Override
    public Integer nextStep() {
        if (randomGenerator.randomNumber() >= MOVABLE_BOUNDARY) {
            return 1;
        }
        return 0;
    }
}
