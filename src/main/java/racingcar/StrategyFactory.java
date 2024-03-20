package racingcar;

public class StrategyFactory {
    public static CarMoveStrategy[] getCarMoveStrategies() {
        return new CarMoveStrategy[] {new RandomCarMoveStrategy()};
    }
}
