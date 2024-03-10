package racingcar.domain;

import java.util.Random;

public class SixtyPercentAdvanceGenerator implements CarMoveGenerator {
    private static final int UPPER_BOUND_EXCLUSIVE = 10;
    private static final int ADVANCE_STANDARD = 4;
    private final Random random = new Random();

    @Override
    public boolean advance() {
        return random.nextInt(UPPER_BOUND_EXCLUSIVE) >= ADVANCE_STANDARD;
    }
}
