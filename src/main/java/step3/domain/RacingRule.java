package step3.domain;

import java.util.Random;

public class RacingRule implements RacingMoveRule {

    private static final Random random = new Random();
    private static final int RANGE = 10;
    private static final int MOVE_NUMBER = 4;

    @Override
    public boolean moveRule() {
        return makeRandomNumber() > MOVE_NUMBER;
    }

    public int makeRandomNumber() {
        return random.nextInt(RANGE);
    }
}
