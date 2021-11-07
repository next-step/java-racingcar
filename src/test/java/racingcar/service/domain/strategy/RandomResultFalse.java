package racingcar.service.domain.strategy;

import racingcar.service.strategy.RoundRule;

public class RandomResultFalse implements RoundRule {
    @Override
    public boolean checkCondition() {
        return false;
    }
}
