package racing.domain;

import java.util.Objects;

public class Car {

    private TravelDistance travelDistance;
    private final Name name;

    public Car(String name) {
        this.travelDistance = new TravelDistance();
        this.name = new Name(name);
    }

    public Car(TravelDistance travelDistance, Name name) {
        this.travelDistance = travelDistance;
        this.name = name;
    }

    public Car move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMoveAble()) {
            travelDistance = travelDistance.move();
        }

        return new Car(travelDistance, name);
    }

    public int getPosition() {
        return travelDistance.getPosition();
    }

    public String getName() {
        return name.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(travelDistance, car.travelDistance) &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(travelDistance, name);
    }
}
