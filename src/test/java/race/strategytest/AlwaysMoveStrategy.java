package race.strategytest;

import race.strategy.MoveStrategy;

public class AlwaysMoveStrategy implements MoveStrategy {
    @Override
    public boolean isMovable() {
        return true;
    }
}
