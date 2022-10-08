package step4.model;

import step4.strategy.MoveStrategy;

import java.util.Objects;

public class Car {
    private final CarName carName;
    private Position position;
    public Car(final String name) {
        this(name, 0);
    }

    public Car(final String name, final int position){
        this.carName = new CarName(name);
        this.position = new Position(position);
    }

    public String getName() {
        return carName.getCarName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public void move(final MoveStrategy moveStrategy) {
        if (moveStrategy.movable()) {
            this.position = position.increase(position);
        }
    }
    public int maxPosition(int maxPosition) {
        return position.maxPosition(maxPosition);
    }

    public boolean isMaxPosition(int maxPosition) {
        return position.isMaxPosition(maxPosition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carName, car.carName) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }
}
