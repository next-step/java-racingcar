package com.nextstep.racingcargame.core;


public class Car {

    private int distance;
    private final String carName;

    private static final int MINIMUM_CAR_MOVE_NUMBER = 4;

    private static final int CAR_NAME_MAX_LENGTH = 5;

    private static final int CAR_START_POSITION_NUMBER = 0;

    private static final String CAR_NAME_MORE_THAN_FIVE_CHARACTER = "자동차 이름은 5자를 초과할 수 없습니다.";

    private static final String CAR_EMPTY_VALUE_MSG = "차 이름이 임력되지 않았습니다.";

    private static final int MOVE_STEP = 1;

    public Car(String carName) {
        if(carNameEmpty(carName)) {
            throw new IllegalArgumentException(CAR_EMPTY_VALUE_MSG);
        }
        if (hasCarNameMoreThanFiveCharacter(carName)) {
            throw new IllegalArgumentException(CAR_NAME_MORE_THAN_FIVE_CHARACTER);
        }
        this.carName = carName;
        this.distance = CAR_START_POSITION_NUMBER;
    }

    public String getDistanceAsPrintForm(String separator, String distancePrintStandard) {
        return this.carName + separator + distanceForm(distancePrintStandard);
    }

    private String distanceForm(String distancePrintStandard) {
        return distancePrintStandard.repeat(this.distance);
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
        }
    }

    private boolean isGoForwardNumber(int randomNumber) {
        return randomNumber >= MINIMUM_CAR_MOVE_NUMBER;
    }

    private boolean carNameEmpty(String carName) {
        return carName == null || carName.isEmpty();
    }

    private boolean hasCarNameMoreThanFiveCharacter(String carName) {
        return carName.length() > CAR_NAME_MAX_LENGTH;
    }

}
