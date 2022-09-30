package racingGame.domain.racingRule;

import java.util.Random;

public class RacingRuleDefault implements RacingRule {
    private static final int MAXNUM = 10;
    private static final int LIMIT = 4;
    private static final Random RANDOM = new Random();

    @Override
    public boolean createRandomResult() {
        return RANDOM.nextInt(MAXNUM) >= LIMIT;
    }
}
