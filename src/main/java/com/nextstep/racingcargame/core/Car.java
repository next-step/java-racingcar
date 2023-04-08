package com.nextstep.racingcargame.core;

import static com.nextstep.racingcargame.view.TravelDistanceView.CAR_DISTANCE_DISPLAY_UNIT;

public class Car {

    private int distance;
    private String travelDistance;

    private static final int MAX_RANDOM_VALUE = 9;
    private static final int MAX_STOP_VALUE = 4;

    private static final int MOVE_STEP = 1;

    protected Car() {
        this.distance = 0;
        this.travelDistance = "";
    }

    public void printTravelDistance() {
        System.out.println(travelDistance);
    }

    public int getDistance() {
        return this.distance;
    }

    public void moveForwardByNumber(int randomNumber) {
        if (isGoForwardNumber(randomNumber)) {
            this.distance += MOVE_STEP;
            this.travelDistance += CAR_DISTANCE_DISPLAY_UNIT;
        }
    }

    private boolean isGoForwardNumber(int randomNumber) {
        return randomNumber > MAX_STOP_VALUE;
    }
}
