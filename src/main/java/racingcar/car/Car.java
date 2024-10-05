package racingcar.car;

import racingcar.engine.CarEngine;

public class Car {
    public static final int INITIAL_LOCATION = 0;
    public static final int DEFAULT_MOVE_ENERGY = 4;

    private Position position;
    private final CarName name;

    private Car(CarName name, int position) {
        this.name = name;
        this.position = Position.of(position);
    }

    public static Car createCar(CarName name) {
        return new Car(name, INITIAL_LOCATION);
    }

    public static Car createCar(CarName name, int currentLocation) {
        return new Car(name, currentLocation);
    }

    public void move(CarEngine carEngine) {
        if (carEngine.hasEnoughPower(DEFAULT_MOVE_ENERGY)) {
            position = position.add();
        }
    }

    public int getCurrentLocation() {
        return position.getPosition();
    }

    public String getName() {
        return name.getName();
    }

    public boolean isSame(int maxLocation) {
        return position.isSame(maxLocation);
    }

    public int max(int maxLocation) {
        return position.max(maxLocation);
    }
}
