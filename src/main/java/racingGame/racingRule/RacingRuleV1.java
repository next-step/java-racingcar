package racingGame.racingRule;

public class RacingRuleV1 implements RacingRule{
    @Override
    public boolean createRandomResult() {
        return (int) (Math.random() * (9 - 0 + 1)) >= 4;
    }
}
