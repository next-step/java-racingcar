package study.step3;

import java.util.Random;

public class RandomMoveBehavior implements MoveBehavior {

    public static final Random RANDOM = new Random();

    @Override
    public boolean isMoved() {
        return RANDOM.nextInt(RacingConstant.RANDOM_RAMGE) >= RacingConstant.RANDOM_BOUNDARY_VALUE;
    }
}
