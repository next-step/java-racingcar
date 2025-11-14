package study.racing.domain;

import java.util.Objects;

public class Car {

    private final CarName name;
    private CarPosition position;

    public Car(String name) {
        this(new CarName(name), new CarPosition(0));

    }

    public Car(String name, int position) {
        this(new CarName(name), new CarPosition(position));
    }

    public Car(CarName name, CarPosition position) {
        this.name = name;
        this.position = position;
    }

    public CarName getName() {
        return this.name;
    }

    public CarPosition getPosition() {
        return this.position;
    }

    public void move() {
        if (RandomMoveRule.isRandomNumber()) {
            this.position.increasePosition();
        }
    }

    public void move(int position) {
        this.position = new CarPosition(position);
    }

    public boolean isEqualsMaxPosition(int maxPosition) {
        return this.position.isMaxPosition(maxPosition);
    }

    public int max(int maxPosition) {
        return this.getPosition().max(maxPosition);
    }

    public void moveToPosition(int position) {
        this.position = new CarPosition(position);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(getName(), car.getName()) && Objects.equals(getPosition(), car.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPosition());
    }
}
