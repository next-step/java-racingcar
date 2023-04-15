package com.nextstep.racingcargame.core;


import com.nextstep.racingcargame.util.RandomNumber;
import com.nextstep.racingcargame.util.RandomNumberZeroToNine;
import java.util.Objects;

public class Car {

    private final Distance distance;
    private final Name name;

    private final RandomNumber randomNumber;

    private static final int CAR_START_POSITION_NUMBER = 0;

    private static final String MOVING_STRATEGY_EMPTY = "자동차 이동 전략은 필수 값입니다.";

    public Car(String carName) {
        this(carName, CAR_START_POSITION_NUMBER);
    }

    public Car(String carName, int distance) {
        this(carName, new Distance(distance), new RandomNumberZeroToNine());
    }

    public Car(String carName, Distance distance, RandomNumber randomNumber) {
        if (randomNumber == null) {
            throw new IllegalArgumentException(MOVING_STRATEGY_EMPTY);
        }
        this.name = new Name(carName);
        this.distance = distance;
        this.randomNumber = randomNumber;
    }

    public String getDistanceAsPrintForm(String separator, String distancePrintStandard) {
        return this.name.getCarName()
                + separator
                + this.distance.distanceForm(distancePrintStandard);
    }

    public String getCarName() {
        return this.name.getCarName();
    }

    public Distance getDistance() {
        return this.distance;
    }

    public boolean isLongerThan(Distance distance) {
        return this.distance.isLongerThan(distance);
    }

    public Car move() {
        return new Car(this.name.getCarName(),
                this.distance.moveForward(randomNumber.randomNumber()),
                this.randomNumber);
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
