package study.carracing.domain;

import study.carracing.util.MoveStrategy;

public class Car {

    private static final int INITIAL_POSITION = 1;
    private static final String PROGRESS_DASH = "-";

    private int position;
    private MoveStrategy moveStrategy;

    public Car(MoveStrategy moveStrategy) {
        this.position = INITIAL_POSITION;
        this.moveStrategy = moveStrategy;
    }

    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        if (moveStrategy.canMove()) {
            position += 1;
        }
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return PROGRESS_DASH.repeat(position);
    }
}
