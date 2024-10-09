package racinggame.domain;

import java.util.Objects;

public class Car {

    private static final int MOVE_BOUND = 4;
    private static final int DEFAULT_POSITION = 1;
    private int position;

    public Car(int position) {
        this.position = position;
    }

    public static Car defaultCar(){
        return new Car(DEFAULT_POSITION);
    }

    public void move(int number) {
        if (MOVE_BOUND <= number) {
            position++;
        }
    }

    public int position() {
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
        return position == car.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

}
