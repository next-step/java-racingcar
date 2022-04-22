package carrace;

public class RandomMoving implements Moving {
    private static final int DECISION_VALUE = 4;
    private static final int GO = 1;
    private static final int STOP = 0;

    private final RandomNumberGenerator generator = new RandomNumberGenerator();

    @Override
    public boolean isMove() {
        return generator.getRandomBetweenZeroAndNine() >= DECISION_VALUE;
    }

    public int move(boolean isMove) {
        return isMove ? GO : STOP;
    }
}
