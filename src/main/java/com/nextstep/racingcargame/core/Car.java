package com.nextstep.racingcargame.core;


import java.util.Objects;

public class Car {

    private Distance distance;
    private final Name name;

    private static final int CAR_START_POSITION_NUMBER = 0;

    private static final int MINIMUM_CAR_MOVE_NUMBER = 4;

    public Car(String carName) {
        this(carName, CAR_START_POSITION_NUMBER);
    }

    public Car(String carName, int distance) {
        this(new Name(carName), new Distance(distance));
    }

    public Car(Name name, Distance distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getCarName() {
        return this.name.getCarName();
    }

    public String getDisplayableDistanceForm(String distancePrintStandard) {
        return this.distance.distanceForm(distancePrintStandard);
    }

    public Distance getDistance() {
        return this.distance;
    }

    public boolean isLongerThan(Distance distance) {
        return this.distance.isLongerThan(distance);
    }

    public void move(MovingStrategy movingStrategy) {
        if (isGoForwardNumber(movingStrategy.randomNumber())) {
            this.distance = this.distance.moveForward(movingStrategy.randomNumber());
        }
    }

    private boolean isGoForwardNumber(int randomNumber) {
        return randomNumber >= MINIMUM_CAR_MOVE_NUMBER;
    }

    public boolean sameDistance(Distance distance) {
        return this.distance.isSame(distance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(distance, car.distance) && Objects.equals(name,
                car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance, name);
    }
}
