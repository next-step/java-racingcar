package racingcar.car;

import racingcar.engine.CarEngine;

public class Car {
    public static final int INITIAL_LOCATION = 0;
    public static final int DEFAULT_MOVE_ENERGY = 4;

    private Position position;
    private final String name;

    private Car(String name) {
        this.position = new Position(INITIAL_LOCATION);
        this.name = name;
    }

    private Car(String name, int currentLocation) {
        this.name = name;
        this.position = new Position(currentLocation);
    }

    public static Car createCar(String name) {
        return new Car(name);
    }

    public static Car createCar(String name, int currentLocation) {
        return new Car(name, currentLocation);
    }

    public void move(CarEngine carEngine) {
        if (carEngine.hasEnoughPower(DEFAULT_MOVE_ENERGY)) {
            position = position.add();
        }
    }

    public int getCurrentLocation() {
        return position.getCurrentLocation();
    }

    public String getName() {
        return name;
    }
}
