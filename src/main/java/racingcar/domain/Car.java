package racingcar.domain;

import java.util.Objects;

public class Car implements Comparable {
    private Integer position = 0;
    private final String name;

    public Car(Car car) {
        this.position = car.position;
        this.name = car.name;
    }

    public Car(String name) {
        asserValidName(name);
        this.name = name;
    }

    public void move(MoveType moveType) {
        position += moveType.getMovePosition();
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    private void asserValidName(String name) {
        if (name == null || name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException("차량의 이름은 5글자를 초과할 수 없습니다.");
        }
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
        return Objects.hash(name);
    }


    @Override
    public int compareTo(Object o) {
        if (o == null || getClass() != o.getClass()) {
            throw new IllegalArgumentException();
        }
        if (this == o) {
            return 0;
        }

        return this.position.compareTo(((Car) o).position);
    }
}
