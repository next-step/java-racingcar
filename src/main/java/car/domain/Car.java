package car.domain;

import java.util.Objects;

public class Car {

    private static final int CAR_MOVE_LOWER_LIMIT = 4;
    private static final int CAR_STOP = 0;
    private static final int CAR_MOVE = 1;

    private final CarName name;
    private int position = 0;

    public Car(final String carName) {
        this.name = new CarName(carName);
    }

    public Car(final String carName, int position) {
        this.name = new CarName(carName);
        this.position = position;
    }

    public Car(final CarName carName, int position) {
        this.name = carName;
        this.position = position;
    }


    public String getName() {
        return this.name.getName();
    }

    public int getPosition() {
        return this.position;
    }

    public void move(int carSpeed) {
        if (carSpeed >= CAR_MOVE_LOWER_LIMIT) {
            this.position += CAR_MOVE;
        }
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
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
}
