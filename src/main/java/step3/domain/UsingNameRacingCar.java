package step3.domain;

import step3.strategy.move.MoveStrategy;

public class UsingNameRacingCar {

    private final String name;
    private int currentLocation;

    private UsingNameRacingCar(String name) {
        this.name = name;
    }

    public static UsingNameRacingCar of(String name) {
        return new UsingNameRacingCar(name);
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            currentLocation++;
        }
    }

    public int getCurrentLocation() {
        return currentLocation;
    }

    public String getName() {
        return name;
    }
}
