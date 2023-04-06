package step3.domain;

import step3.strategy.MoveStrategy;

public class RacingCar {

    private final MoveStrategy moveStrategy;
    private final Position position;

    private RacingCar(MoveStrategy moveStrategy, Position position) {

        this.moveStrategy = moveStrategy;
        this.position = position;
    }

    public void move() {
        if (moveStrategy.isMovable()) {
            position.increase();
        }
    }

    public static RacingCar of(MoveStrategy moveStrategy, Position position) {
        return new RacingCar(moveStrategy, position);
    }

    public MoveStrategy getMoveStrategy() {
        return moveStrategy;
    }

    public Position getPosition() {
        return position;
    }
}
