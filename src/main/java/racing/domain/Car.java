package racing.domain;

import java.util.Objects;

import static racing.domain.Distance.MIN_DISTANCE_BOUND;

public class Car {

    private final CarName carName;
    private final Distance distance;

    public Car(CarName carName){
        this.carName = carName;
        this.distance = new Distance(MIN_DISTANCE_BOUND);
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

    public boolean isSameDistance(Distance distance){
        return this.distance.equals(distance);
    }
}
