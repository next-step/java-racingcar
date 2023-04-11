package racing.domain;

import racing.strategy.MoveStrategy;

public class RacingCar {
    private int position;
    private MoveStrategy moveStrategy;

    public int getPosition() {
        return position;
    }

    public RacingCar() {
        this.position = 0;
    }

    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        if (moveStrategy.move()) {
            position++;
        }
    }
}
