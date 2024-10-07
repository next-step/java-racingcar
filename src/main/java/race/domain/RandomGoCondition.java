package race.domain;

import java.util.Random;

public class RandomGoCondition implements GoCondition {
    public static final int RANDOM_UPPER_LIMIT = 10;
    private static final int MINIMUM_TO_GO_FORWARD = 4;

    @Override
    public boolean canGo() {
        int randomNumber = generateIntBetween0and9();
        return randomNumber >= MINIMUM_TO_GO_FORWARD;
    }

    private static int generateIntBetween0and9() {
        return new Random().nextInt(RANDOM_UPPER_LIMIT);
    }
}
