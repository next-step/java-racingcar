package racingcar.domain;

import java.util.Objects;

public class Car {
    private static final int FORWARD_NUM = 4;

    private Position position = new Position(1);
    private final CarName name;

    public Car (String name) {
        this.name = new CarName(name);
    }

    public Car(String name, int position) {
        this.name = new CarName(name);
        this.position = new Position(position);
    }

    public Position getPosition() {
        return position;
    }

    public CarName getName() {
        return name;
    }

    public void move(int randomNo) {
        if(randomNo >= FORWARD_NUM) {
            position.move();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(position, car.position) &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }
}