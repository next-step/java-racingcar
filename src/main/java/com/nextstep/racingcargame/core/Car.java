package com.nextstep.racingcargame.core;


import java.util.Objects;

public class Car {

    private final Distance distance;
    private final CarName carName;

    private static final int CAR_START_POSITION_NUMBER = 0;

    public Car(String carName) {
        this(carName, CAR_START_POSITION_NUMBER);
    }

    public Car(String carName, int distance) {
        this(carName, new Distance(distance));
    }

    public Car(String carName, Distance distance) {
        this.carName = new CarName(carName);
        this.distance = distance;
    }

    public String getDistanceAsPrintForm(String separator, String distancePrintStandard) {
        return this.carName.getCarName()
                + separator
                + this.distance.distanceForm(distancePrintStandard);
    }

    public String getCarName() {
        return this.carName.getCarName();
    }

    public Distance getDistance() {
        return this.distance;
    }

    public boolean isLongerThan(Distance distance) {
        return this.distance.isLongerThan(distance);
    }

    public Car moveForwardByNumber(int randomNumber) {
        return new Car(this.carName.getCarName(), this.distance.moveForward(randomNumber));
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
        return Objects.equals(distance, car.distance) && Objects.equals(carName,
                car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance, carName);
    }
}
