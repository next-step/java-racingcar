package racingcar.domain;

public class ForwardStrategyGenerator implements StrategyGenerator {
    @Override
    public MoveStrategy generate() {
        return new ForwardStrategy();
    }
}
