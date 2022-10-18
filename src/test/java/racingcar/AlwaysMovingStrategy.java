package racingcar;

import racingcar.strategy.MovingStrategy;

public class AlwaysMovingStrategy implements MovingStrategy {

    @Override
    public int move() {
        return 1;
    }
}
