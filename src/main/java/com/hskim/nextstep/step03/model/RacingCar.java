package com.hskim.nextstep.step03.model;

public class RacingCar {

    public static final int CAR_NAME_LIMIT = 5;
    private final String carName;
    private int totalMovedDistance;

    public RacingCar(String carName) {

        this.carName = carName;
        totalMovedDistance = 0;
    }

    public int moveForward(int distance, MovableStrategy movableStrategy) {

        if (movableStrategy.isMovable()) {
            return totalMovedDistance += distance;
        }

        return totalMovedDistance;
    }

    // getter
    public String getCarName() {
        return carName;
    }

    public int getTotalMovedDistance() {
        return totalMovedDistance;
    }

}
