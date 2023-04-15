package com.nextstep.racingcargame.core;


import java.util.Objects;

public class Car {

    private final Distance distance;
    private final Name name;

    private static final int CAR_START_POSITION_NUMBER = 0;

    public Car(String carName) {
        this(carName, CAR_START_POSITION_NUMBER);
    }

    public Car(String carName, int distance) {
        this(carName, new Distance(distance));
    }

    public Car(String carName, Distance distance) {
        this.name = new Name(carName);
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
        this.distance.moveForward(movingStrategy.randomNumber());
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
