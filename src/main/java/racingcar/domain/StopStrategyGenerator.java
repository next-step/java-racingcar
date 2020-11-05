package racingcar.domain;

public class StopStrategyGenerator implements StrategyGenerator{
    @Override
    public MoveStrategy generate() {
        return new StopStrategy();
    }
}
