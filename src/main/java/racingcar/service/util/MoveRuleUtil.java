package racingcar.service.util;

import racingcar.service.strategy.MoveRule;

public class MoveRuleUtil implements MoveRule {

    private static final int MIN_RANDOM = 4;
    private static final int MAX_RANDOM = 10;

    @Override
    public boolean moveOrNot() {
        return MIN_RANDOM <= RacingUtil.getRandomValue(MAX_RANDOM);
    }
}
