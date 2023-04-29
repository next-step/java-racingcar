package racingcar;

public class RandomMovingStrategy implements MovingStrategy {

    private static final int THRESHOLD = 4;
    private final RandomNumberGenerator randomNumberGenerator;

    public RandomMovingStrategy(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public boolean isMove() {
        return randomNumberGenerator.generateNumber() >= THRESHOLD;
    }
}
