package racinggamewinner.random;

public class RandomStrategy {
    private RandomGenerator randomGeneratorStrategy;

    public RandomStrategy(RandomGenerator randomGeneratorStrategy) {
        this.randomGeneratorStrategy = randomGeneratorStrategy;
    }

    public int executeStrategy() {
        return randomGeneratorStrategy.generateRandomNumber();
    }

    public void changeStrategy(RandomGenerator randomGenerator) {
        randomGeneratorStrategy.generateRandomNumber();
    }
}
