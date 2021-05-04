package racing.domain;

import java.util.Objects;

public class Car implements Comparable<Car>{
    private CarName carName;
    private Distance distance;
    private MovableStrategy movableStrategy;

    private Car(CarName carName, MovableStrategy movableStrategy) {
        this.carName = carName;
        this.movableStrategy = movableStrategy;
        this.distance = Distance.zero;
    }

    public static Car of(String name, MovableStrategy movableStrategy) {
        return new Car(CarName.of(name), movableStrategy);
    }

    public void move() {
        if (movableStrategy.movable()) {
            this.distance = this.distance.plus(Distance.one);
        }
    }

    public boolean isSameDistance(Distance distance) {
        return Objects.equals(this.distance, distance);
    }

    public Distance getDistance() {
        return this.distance;
    }

    public int distance() {
        return this.distance.getDistance();
    }

    public String carName() {
        return this.carName.getName();
    }

    @Override
    public int compareTo(Car o) {
        if(this.distance() > o.distance()) {
            return 1;
        }
        return -1;
    }
}
