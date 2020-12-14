package race.domain;

import java.util.Objects;

public class Car {

    private final MovePolicy movePolicy;
    private final CarName carName;
    private final Distance distance;

    public Car(MovePolicy movePolicy) {
        this(null, movePolicy);
    }

    public Car(CarName carName, MovePolicy movePolicy) {
        this.movePolicy = movePolicy;
        this.carName = carName;
        this.distance = new Distance();
    }

    public void move() {
        distance.add(movePolicy.move());
    }

    public int getMovedDistance() {
        return distance.get();
    }

    public String getName() {
        if (carName == null) {
            return "";
        }
        return carName.get();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carName, car.carName) &&
                Objects.equals(distance, car.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movePolicy, carName, distance);
    }
}
