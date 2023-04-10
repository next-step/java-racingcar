package com.nextstep.racingcargame.core;

import static com.nextstep.racingcargame.view.ClientView.printSource;

public class Car {

    private int distance;
    private String travelDistance;

    private String carName;

    private static final int MINIMUM_CAR_MOVE_NUMBER = 4;

    private static final String CAR_DISTANCE_DISPLAY_UNIT = "-";

    private static final int CAR_START_POSITION_NUMBER = 0;

    private static final String CAR_START_POSITION_DISPLAY_STRING = "";

    private static final int MOVE_STEP = 1;

    protected Car(String carName) {
        this.carName = carName;
        this.distance = CAR_START_POSITION_NUMBER;
        this.travelDistance = CAR_START_POSITION_DISPLAY_STRING;
    }

    public void printTravelDistance() {
        printSource(travelDistance);
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
        return randomNumber >= MINIMUM_CAR_MOVE_NUMBER;
    }
}
