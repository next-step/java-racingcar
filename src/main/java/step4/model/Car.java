package step4.model;

import java.util.Objects;

public class Car {

    private final Name name;
    private Distance distance;

    public Car(final String name) {
        this(name, 0);
    }

    public Car(final String name, final int distance) {
        this.name = new Name(name);
        this.distance = new Distance(distance);
    }

    void move(MoveStrategy moveStrategy){
        if(moveStrategy.movable()){
            this.distance.increase();
        }
    }
    public Distance max(Distance other) {
        return this.distance.farthestDistance(other);
    }

    public boolean isWinner(Distance maxPosition) {
        return this.distance.equals(maxPosition);
    }

    public int distance() {
        return distance.distance();
    }

    public String getName() {
        return name.name();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Car car = (Car) other;
        return Objects.equals(name, car.name) &&
                Objects.equals(distance, car.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distance);
    }


}
