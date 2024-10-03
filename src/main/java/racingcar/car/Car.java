package racingcar.car;

import racingcar.engine.CarEngine;

public class Car {
    public static final int INITIAL_LOCATION = 0;
    public static final int DEFAULT_MOVE_ENERGY = 4;

    private Position position;

    private Car() {
        this.position = new Position(INITIAL_LOCATION);
    }

    public static Car createCar() {
        return new Car();
    }

    public void move(CarEngine carEngine) {
        if (carEngine.hasEnoughPower(DEFAULT_MOVE_ENERGY)) {
            position = position.add();
        }
    }

    public int getCurrentLocation() {
        return position.getCurrentLocation();
    }
}
