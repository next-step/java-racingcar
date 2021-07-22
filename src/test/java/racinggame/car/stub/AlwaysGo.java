package racinggame.car.stub;

import racinggame.strategy.MovingStrategy;

public class AlwaysGo implements MovingStrategy {
    @Override
    public boolean isMove() {
        return true;
    }
}
