package racinggame.domain.random;

import java.util.Random;

public class RandomGoRule implements GoRule {

    public static final int GO_MIN_VALUE = 4;
    private static final Random random = new Random();
    private static final int LIMIT = 10;

    @Override
    public boolean isGo() {
        return random.nextInt(LIMIT) >= GO_MIN_VALUE;
    }
}
