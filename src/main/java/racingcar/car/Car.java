package racingcar.car;

import racingcar.engine.CarEngine;

public class Car {

    private Position position;

    private Car() {
        this.position = new Position();
    }

    public static Car createCar() {
        return new Car();
    }

    public void move(CarEngine carEngine) {
        if (carEngine.hasEnoughPower()) {
            position.add();
        }
    }

    public int getCurrentLocation() {
        return position.getCurrentLocation();
    }
}
