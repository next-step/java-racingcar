package racingcar.service.domain.strategy;

import racingcar.service.strategy.RoundRule;

public class RandomResultTrue implements RoundRule {
    @Override
    public boolean checkCondition() {
        return true;
    }
}
