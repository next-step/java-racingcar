package step3.domain.strategy;

import step3.domain.AdvanceCheckor;
import step3.domain.RandomGenerator;

public class RandomMovingStrategy implements MovingStrategy<Boolean> {

    private RandomGenerator randomGenerator;
    private AdvanceCheckor checkor;

    public RandomMovingStrategy(RandomGenerator randomGenerator, AdvanceCheckor checkor) {
        this.randomGenerator = randomGenerator;
        this.checkor = checkor;
    }

    @Override
    public Boolean isMove() {
        return checkor.check(randomGenerator.generate());
    }

}
