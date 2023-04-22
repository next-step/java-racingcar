package step3.domain;

import java.util.Objects;

public class Car {
    private final static int DEFAULT_POSITION = 0;
    private final CarName name;
    private final CarPosition position;

    public Car(String name) {
        this.name = CarName.of(name);
        this.position = CarPosition.of(DEFAULT_POSITION);
    }

    public Car(String name, int position) {
        this.name = CarName.of(name);
        this.position = CarPosition.of(position);
    }

    public CarName getName() {
        return name;
    }

    public CarPosition getPosition() {
        return position;
    }

    public String getNameValue() {
        return name.getValue();
    }

    public int getPositionValue() {
        return position.getValue();
    }

    public void move(boolean canMove) {
        if (canMove) this.position.move();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Car)) {
            return false;
        }
        Car car = (Car) o;
        return car.name.equals(name) && car.position == position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
