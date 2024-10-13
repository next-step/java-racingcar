package racinggame.domain;

import java.util.Objects;

public class Car {

    private static final int MOVE_BOUND = 4;
    private static final int DEFAULT_POSITION = 1;

    private int position;
    private String name;

    public Car(int position, String name) {
        if (isNotInvalidName(name)) {
            throw new IllegalArgumentException("자동차의 이름의 길이는 1이상 4이하여야 합니다.");
        }
        this.position = position;
        this.name = name;
    }

    private boolean isNotInvalidName(String name) {
        return name == null || name.isBlank() || 4 < name.length();
    }

    public static Car defaultCar(String name) {
        return new Car(DEFAULT_POSITION, name);
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
