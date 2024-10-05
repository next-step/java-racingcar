package racingcar.logic;

import racingcar.logic.movableStrategy.MovableStrategy;

public class RacingCar {
    private static final int INITIAL_POSITION = 0;

    private final String name;
    private final int carNo;
    private int position;

    private RacingCar(String name, int carNo) {
        this.name = name;
        this.carNo = carNo;
        this.position = INITIAL_POSITION;
    }

    public static RacingCar valueOf(String name, int carNo) {
        return new RacingCar(name, carNo);
    }

    public void race(MovableStrategy movableStrategy) {
        if (movableStrategy.isMove()) {
            this.position++;
        }
    }

    public int getCarNo() {
        return this.carNo;
    }

    public int getPosition() {
        return this.position;
    }
}
