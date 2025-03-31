package racingcar.domain;

import java.util.Objects;

public class Car {

    private static final int INITIAL_POSITION = 0;

    private final CarName name;
    private int position;

    public Car(String name) {
        this.name = new CarName(name);
        position = INITIAL_POSITION;
    }

    public void move(boolean canMove) {
        if (canMove) {
            position++;
        }
    }

    public String getName() {
        return this.name.getCarName();
    }


    public int getPosition() {
        return position;
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

        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

}
