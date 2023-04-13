package com.nextstep.racingcargame.core;


public class Car {

    private Distance distance;
    private final String carName;

    private static final int CAR_NAME_MAX_LENGTH = 5;

    private static final int CAR_START_POSITION_NUMBER = 0;

    private static final String CAR_NAME_MORE_THAN_FIVE_CHARACTER = "자동차 이름은 5자를 초과할 수 없습니다.";

    private static final String CAR_EMPTY_VALUE_MSG = "차 이름이 임력되지 않았습니다.";


    public Car(String carName) {
        this(carName, CAR_START_POSITION_NUMBER);
    }

    public Car(String carName, int distance) {
        if(carNameEmpty(carName)) {
            throw new IllegalArgumentException(CAR_EMPTY_VALUE_MSG);
        }
        if (hasCarNameMoreThanFiveCharacter(carName)) {
            throw new IllegalArgumentException(CAR_NAME_MORE_THAN_FIVE_CHARACTER);
        }
        this.carName = carName;
        this.distance = new Distance(distance);
    }

    public String getDistanceAsPrintForm(String separator, String distancePrintStandard) {
        return this.carName + separator + this.distance.distanceForm(distancePrintStandard);
    }

    public String getCarName() {
        return this.carName;
    }

    public Distance getDistance() {
        return this.distance;
    }

    public boolean isLongerThan(Distance distance) {
        return this.distance.isLongerThan(distance);
    }

    public void moveForwardByNumber(int randomNumber) {
        this.distance = this.distance.moveForward(randomNumber);
    }

    private boolean carNameEmpty(String carName) {
        return carName == null || carName.isEmpty();
    }

    private boolean hasCarNameMoreThanFiveCharacter(String carName) {
        return carName.length() > CAR_NAME_MAX_LENGTH;
    }

}
