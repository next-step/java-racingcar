package racingcar.service.strategy;

import racingcar.utils.RandomUtils;

public class RandomRoundRule implements RoundRule {
    private static final int MIN_NUMBER = 4;
    private static final int MAX_NUMBER = 10;

    @Override
    public boolean checkCondition() {
        return MIN_NUMBER > RandomUtils.getRandomNumber(MAX_NUMBER);
    }
}
