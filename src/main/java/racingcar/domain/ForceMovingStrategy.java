package racingcar;

public class ForceMovingStrategy implements MovingStrategy {

    private static final int THRESHOLD = 4;
    private final RandomNumberGenerator randomNumberGenerator;

    public ForceMovingStrategy(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public boolean isMove() {
        return randomNumberGenerator.generateNumberAboveFour() >= THRESHOLD;
    }
}
