package racingcarGame;

import java.util.Objects;

public class Car {
    private static final String POSITION_STR = "-";

    private String position;

    public Car(String position) {
        this.position = position;
    }

    public Car move() {
        this.position += POSITION_STR;
        return new Car(position);
    }

    public String getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
