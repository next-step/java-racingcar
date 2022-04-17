package carrace;

public class RandomMoving implements Moving {
    private final RandomNumberGenerator generator = new RandomNumberGenerator();
    private static final int DECISION_VALUE = 4;

    @Override
    public boolean isMove() {
        return generator.getRandomBetweenZeroAndNine() >= DECISION_VALUE;
    }
}
