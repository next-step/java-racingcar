package racing.core;

import java.util.Objects;

import static racing.core.Distance.DEFAULT_MIN_BOUND;

public class Car {

    private final CarName carName;
    private final Distance distance;

    public Car(CarName carName, Distance distance){
        this.carName = carName;
        this.distance = distance;
    }

    public Car(CarName carName){
        this.carName = carName;
        this.distance = new Distance(DEFAULT_MIN_BOUND);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carName, car.carName) && Objects.equals(distance, car.distance);
    }

    public CarName getCarName() {
        return carName;
    }

    public Distance getDistance() {
        return distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, distance);
    }

    public void stepAhead() {
        distance.stepAhead();
    }

    public boolean isSameDistance(int distance){
        return this.distance.getDistance() == distance;
    }
}
