package racingcar;

public class RandomNumCondition implements Condition {
    private RandomGenerator randomGenerator;

    public RandomNumCondition(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    @Override
    public boolean isSatisfied() {
        return randomGenerator.generate() >= 4;
    }
}
