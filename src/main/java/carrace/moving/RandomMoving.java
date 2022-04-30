package carrace.moving;

import carrace.util.RandomNumberGenerator;

public class RandomMoving implements Moving {
    private static final int DECISION_VALUE = 4;
    private static final int GO = 1;
    private static final int STOP = 0;

    private final RandomNumberGenerator generator = new RandomNumberGenerator();
    @Override
    public int move() {
        return generator.getRandomBetweenZeroAndNine() >= DECISION_VALUE ? GO : STOP;
    }
}
