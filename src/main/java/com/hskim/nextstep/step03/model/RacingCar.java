package com.hskim.nextstep.step03.model;

import com.hskim.nextstep.step03.utils.RandomUtils;

import java.util.LinkedList;
import java.util.List;

public class RacingCar {

    private int carNo;
    private static final int RANDOM_BOUND = 10;
    private static final int MOVABLE_LOWER_BOUND = 4;
    private List<Integer> movedHistory;
    private int totalMovedDistance;

    public RacingCar(int carNo) {

        this.carNo = carNo;
        movedHistory = new LinkedList<>();
        totalMovedDistance = 0;
    }

    public int moveForward(int distance) {

        if (checkMovable()) {
            movedHistory.add(distance);
            return totalMovedDistance += distance;
        }

        return totalMovedDistance;
    }

    private boolean checkMovable() {

        return RandomUtils.getRandomInteger(RANDOM_BOUND) >= MOVABLE_LOWER_BOUND;
    }

    // getter
    public int getCarNo() {
        return carNo;
    }

    public int getTotalMovedDistance() {
        return totalMovedDistance;
    }

}
