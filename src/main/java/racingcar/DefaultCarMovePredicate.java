package racingcar;

import java.util.Random;

public class DefaultCarMovePredicate implements CarMovePredicate {
    private static final int LIMIT = 10;
    private static final int SUCCESS_CRITERIA = 3;
    private final Random random = new Random();

    @Override
    public boolean test() {
        return random.nextInt(LIMIT) > SUCCESS_CRITERIA;
    }
}
