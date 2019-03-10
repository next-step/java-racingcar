package racinggame.domain;

import racinggame.utils.StringUtils;

import java.util.Objects;

public class Car {
    private static final int FORWARD_NUM = 4;

    private String name;
    private int position = 0;

    Car(String name) {
        this(name, 0);
    }

    Car(String name, int position) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("자동차 이름은 값이 존재해야 합니다.");
        }
        this.name = name.trim();
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    void move(int number) {
        if (number >= FORWARD_NUM) {
            position++;
        }
    }

    boolean isMaxPosition(int maxPosition) {
        return this.position == maxPosition;
    }

    int getMaxPosition(int maxPosition) {
        if (position > maxPosition) {
            return position;
        }
        return maxPosition;
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
}
