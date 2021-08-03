package racingcar.entity;


import racingcar.strategy.MoveStrategy;

public class RacingCar {
    public static final int BASE_POSITION = 0;
    public static final int ONE_STEP = 1;

    private String name;
    private int position;

    public RacingCar(String carName) {
        this.position = BASE_POSITION;
        this.name = carName;
    }

    public void moveIfMovable(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable())
            position += ONE_STEP;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
