package step5.domain;

import step5.strategy.move.MoveStrategy;

public class RacingCar {
    private final String name;
    private int currentLocation;

    private RacingCar(String name) {
        this.name = name;
    }

    public static RacingCar from(String name) {
        return new RacingCar(name);
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

    public boolean isWinner(int maxPosition) {
        return currentLocation == maxPosition;
    }
}
