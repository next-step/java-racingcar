package racingcar.entity;


import racingcar.strategy.MoveStrategy;

public class RacingCar {
    public static final int BASE_POSITION = 0;
    public static final int ONE_STEP = 1;
    private MoveStrategy moveStrategy;

    private int position;

    public int getPosition() {
        return position;
    }

    public RacingCar(MoveStrategy moveStrategy) {
        this.position = BASE_POSITION;
        this.moveStrategy = moveStrategy;
    }

    public void moveIfMovable() {
        if (moveStrategy.isMovable())
            position += ONE_STEP;
    }
}
