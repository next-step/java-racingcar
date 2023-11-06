package racingcar.strategy;

import racingcar.strategy.MoveStrategy;

public class FixtureMoveStrategy implements MoveStrategy {

    private final int moveNumber;

    public FixtureMoveStrategy(int moveNumber) {
        this.moveNumber = moveNumber;
    }

    @Override
    public int move() {
        return moveNumber;
    }
}
