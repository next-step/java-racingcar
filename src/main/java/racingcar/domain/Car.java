package racingcar.domain;

import java.util.Objects;

public class Car {
    public static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private final Position position;

    public Car(String name, Position position) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 5글자를 초과할 수 없습니다. 입력된 이름 : " + name);
        }

        this.position = position;
        this.name = name;
    }

    public static Car create(String name) {
         return new Car(name, Position.init());
    }

    public void move(int number) {
        this.position.move(number);
    }

    public String name() {
        return this.name;
    }

    public int positionNumber() {
        return this.position.position();
    }

    public Position position() {
        return this.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
