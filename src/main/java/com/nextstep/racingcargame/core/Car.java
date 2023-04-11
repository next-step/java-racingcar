package com.nextstep.racingcargame.core;

import static com.nextstep.racingcargame.view.ClientView.printSource;

public class Car {

    private int distance;
    private String travelDistance;

    private final String carName;

    private static final int MINIMUM_CAR_MOVE_NUMBER = 4;

    private static final int CAR_NAME_MAX_LENGTH = 5;

    private static final String CAR_DISTANCE_DISPLAY_UNIT = "-";

    private static final int CAR_START_POSITION_NUMBER = 0;

    private static final String CAR_START_POSITION_DISPLAY_STRING = "";

    private static final String CAR_NAME_AND_DISTANCE_DELIMITER = " : ";

    private static final String CAR_NAME_MORE_THAN_FIVE_CHARACTER = "자동차 이름은 5자를 초과할 수 없습니다.";

    private static final int MOVE_STEP = 1;

    public Car(String carName) {
        if (hasCarNameMoreThanFiveCharacter(carName)) {
            throw new IllegalArgumentException(CAR_NAME_MORE_THAN_FIVE_CHARACTER);
        }
        this.carName = carName;
        this.distance = CAR_START_POSITION_NUMBER;
        this.travelDistance = CAR_START_POSITION_DISPLAY_STRING;
    }

    public void printTravelDistanceWithCarName() {
        printSource(getDistanceAsPrintForm());
    }

    public String getDistanceAsPrintForm() {
        return this.carName + CAR_NAME_AND_DISTANCE_DELIMITER + this.travelDistance;
    }

    public String getCarName() {
        return this.carName;
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

    private boolean hasCarNameMoreThanFiveCharacter(String carName) {
        return carName.length() > CAR_NAME_MAX_LENGTH;
    }
}
