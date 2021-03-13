package study.step4;

import java.util.Random;

public class RandomMoveBehavior implements MoveBehavior {

    private static final int RANDOM_RAMGE = 10;
    private static final int RANDOM_BOUNDARY_VALUE = 4;
    private static final Random RANDOM = new Random();

    @Override
    public boolean isMoved() {
        return RANDOM.nextInt(RANDOM_RAMGE) > RANDOM_BOUNDARY_VALUE;
    }
}
