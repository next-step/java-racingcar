package study.racing.domain;

import study.racing.domain.move.MoveStrategy;
import study.racing.domain.move.RandomMoveStrategy;

import java.util.Objects;

public class Car {

    private final CarName name;
    private CarPosition position;
    private final MoveStrategy moveStrategy;

    public Car(String name) {
        this(new CarName(name), new CarPosition(0), new RandomMoveStrategy());

    }

    public Car(String name, MoveStrategy moveStrategy) {
        this(new CarName(name), new CarPosition(0), moveStrategy);
    }

    public Car(String name, int position) {
        this(new CarName(name), new CarPosition(position), new RandomMoveStrategy());
    }

    public Car(CarName name, CarPosition position, MoveStrategy moveStrategy) {
        this.name = name;
        this.position = position;
        this.moveStrategy = moveStrategy;
    }

    public CarName getName() {
        return this.name;
    }

    public CarPosition getPosition() {
        return this.position;
    }

    public void move() {
        if (this.moveStrategy.isMove()) {
            this.position.increasePosition();
        }
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
