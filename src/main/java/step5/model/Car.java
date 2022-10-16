package step5.model;

import step5.strategy.MoveStrategy;

import java.util.Objects;

public class Car {
    private final CarName carName;
    private final Position position;
    public Car(final String name) {
        this(name, 0);
    }

    public Car(final String name, final int position){
        this.carName = new CarName(name);
        this.position = new Position(position);
    }

    public void move(final MoveStrategy moveStrategy) {
        if (moveStrategy.movable()) {
            this.position.increase();
        }
    }
    public int maxPosition(int maxPosition) {
        return position.maxPosition(maxPosition);
    }

    public boolean isMaxPosition(int maxPosition) {
        return position.isSamePosition(maxPosition);
    }

    public String getName() {
        return carName.getName();
    }

    public int getPosition() {
        return position.getPosition();
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

    @Override
    public String toString() {
        return "Car{" +
                "carName=" + carName +
                ", position=" + position +
                '}';
    }
}
