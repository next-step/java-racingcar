package racingGame.racingRule;

import racingGame.domain.racingRule.RacingRule;

public class NotMoveRule implements RacingRule {
    @Override
    public boolean createRandomResult() {
        return false;
    }
}
