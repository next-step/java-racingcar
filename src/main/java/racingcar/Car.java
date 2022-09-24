package racingcar;

import java.util.Objects;

public class Car {
    private static final Integer MOVE_CRITERIA = 4;

    private final Integer position;
    private final String name;

    private Car(Integer position, String name) {
        this.position = position;
        this.name = name;
    }

    static Car of(Integer position, String name) {
        return new Car(position, name);
    }

    public Integer position() {
        return position;
    }

    public String name() {
        return name;
    }

    Car move(Integer randomNumber) {
        return Car.of(nextPosition(randomNumber), name);
    }

    private Integer nextPosition(Integer randomNumber) {
        if (randomNumber >= MOVE_CRITERIA) {
            return position + 1;
        }
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(position, car.position) && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }
}
