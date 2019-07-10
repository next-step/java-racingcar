package homework.week1.racingcar.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("차이름은 빈 문자열이나 공백문자열이 올 수 없습니다.");
        }
        this.name = name;
        this.position = position;
    }

    int move(boolean movable) {
        if (movable) {
            ++position;
        }
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position &&
                Objects.equals(name, car.name);
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

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
