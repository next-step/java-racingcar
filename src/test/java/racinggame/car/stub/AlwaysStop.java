package racinggame.car.stub;

import racinggame.strategy.MovingStrategy;

public class AlwaysStop implements MovingStrategy {
    @Override
    public boolean isMove() {
        return false;
    }
}
