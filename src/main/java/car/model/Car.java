package car.model;

import java.util.Objects;

public final class Car {

    private static final int CAR_MOVE_LOWER_LIMIT = 4;
    private static final int CAR_MOVE = 1;

    private final CarName name;
    private final int position;

    public Car(final String carName, final int position) {
        this.name = new CarName(carName);
        this.position = position;
    }

    public Car(final String carName) {
        this(carName, 0);
    }

    public Car(final CarName carName, final int position) {
        this.name = carName;
        this.position = position;
    }

    public String getName() {
        return this.name.getName();
    }

    public int getPosition() {
        return this.position;
    }

    public Car move(final int carSpeed) {
        if (carSpeed >= CAR_MOVE_LOWER_LIMIT) {
            return new Car(this.name, this.position + CAR_MOVE);
        }
        return this;
    }

    public boolean isSamePosition(final int position) {
        return this.position == position;
    }

    public boolean isSamePosition(final Car otherCar) {
        return this.position == otherCar.getPosition();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return "Car{" +
            "name=" + name +
            ", position=" + position +
            '}';
    }

}
