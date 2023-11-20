package racing;

import racing.generator.NumberGenerator;

public class MovableNumberGenerator implements NumberGenerator {
    private static final int DEFAULT_MOVABLE_VALUE = 5;

    @Override
    public int generate() {
        return DEFAULT_MOVABLE_VALUE;
    }
}
