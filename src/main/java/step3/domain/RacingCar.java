package step3.domain;

import step3.move.MoveStrategy;
import step3.move.RandomMoveStrategy;

public class RacingCar {
    private static final int defaultPosition = 0;
    private final MoveStrategy moveStrategyStrategy;

    public RacingCar() {
        moveStrategyStrategy = new RandomMoveStrategy();
    }

    private int position = defaultPosition;

    protected int position() {
        return position;
    }

    protected void resetPosition() {
        position = defaultPosition;
    }

    protected void steeringToForward() {
        position += moveStrategyStrategy.moveAmount();
    }
}

