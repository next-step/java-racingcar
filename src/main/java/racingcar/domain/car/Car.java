package racingcar.domain.car;

import java.util.Objects;

public class Car {
    private static final int DEFAULT_POSITION = 0;
    private String name;
    private int position;

    public Car(String name) {
        this(name, DEFAULT_POSITION);
    }

    public Car(String name, int position) {
        validateName(name);
        validatePosition(position);

        this.name = name;
        this.position = position;
    }

    private void validatePosition(int position) {
        if (position < DEFAULT_POSITION) {
            throw new IllegalArgumentException("자동차 위치는 0보다 커야 합니다.");
        }
    }

    private void validateName(String name) {
        if (Objects.isNull(name) || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 잘못 되었습니다.");
        }
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMovable()) {
            position++;
        }
    }

    public Car clone() {
        return new Car(name, position);
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public boolean isEqualPosition(int maxPosition) {
        return maxPosition == position;
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
}
