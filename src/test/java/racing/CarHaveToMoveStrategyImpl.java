package racing;

import racing.domain.strategies.CarMoveStrategy;

public class CarHaveToMoveStrategyImpl implements CarMoveStrategy {
    @Override
    public boolean isMovable() {
        return true;
    }
}
