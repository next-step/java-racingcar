package step3.domain.strategy;

import step3.domain.AdvanceCheckor;
import step3.domain.RandomGenerator;

public class RandomMovingStrategy implements MovingStrategy {

    private final RandomGenerator randomGenerator;
    private final AdvanceCheckor advanceCheckor;

    public RandomMovingStrategy(RandomGenerator randomGenerator, AdvanceCheckor advanceCheckor) {
        this.randomGenerator = randomGenerator;
        this.advanceCheckor = advanceCheckor;
    }

    @Override
    public boolean isMove() {
        return advanceCheckor.check(randomGenerator.generate());
    }

}
