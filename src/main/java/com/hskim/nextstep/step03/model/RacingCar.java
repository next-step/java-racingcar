package com.hskim.nextstep.step03.model;

import java.util.LinkedList;
import java.util.List;

public class RacingCar {

    public static final int CAR_NAME_LIMIT = 5;
    private final String carName;
    private List<Integer> movedHistory;
    private int totalMovedDistance;

    public RacingCar(String carName) {

        this.carName = carName;
        movedHistory = new LinkedList<>();
        totalMovedDistance = 0;
    }

    public int moveForward(int distance, MovableStrategy movableStrategy) {

        if (movableStrategy.isMovable()) {
            movedHistory.add(distance);
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
