package racingcar.domain;

public class RandomMovingPolicy implements MovingPolicy {
    private static final Integer MOVABLE_BOUNDARY = 4;

    private final Integer randomNumber;

    public RandomMovingPolicy(Integer randomNumber) {
        this.randomNumber = randomNumber;
    }

    @Override
    public Integer nextStep() {
        if (randomNumber >= MOVABLE_BOUNDARY) {
            return 1;
        }
        return 0;
    }
}
