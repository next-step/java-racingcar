package racingcar.entity;


import racingcar.strategy.MoveStrategy;

public class RacingCar {
    public static final int BASE_POSITION = 0;
    public static final int ONE_STEP = 1;

    private int position;

    public int getPosition() {
        return position;
    }

    public RacingCar() {
        this.position = BASE_POSITION;
    }

    public void moveIfMovable(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable())
            position += ONE_STEP;
    }
}
