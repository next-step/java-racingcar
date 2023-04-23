package racingcar.domain;

import java.util.Objects;

public class Car {
    private static final String CAR_NAME_LENGTH_LIMIT_MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다. input: %s";
    public static final String POSITION_MAKER = "-";
    private int position;
    private final String name;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(String.format(CAR_NAME_LENGTH_LIMIT_MESSAGE, name));
        }
        this.name = name;
        this.position = position;
    }

    public static Car max(Car car, Car otherCar) {
        if (car.position < otherCar.position) {
            return otherCar;
        }
        return car;
    }

    public void move(RandomNumber randomNumber) {
        if (randomNumber.isMovable()) {
            position++;
        }
    }

    public boolean isWinner(Car otherCar) {
        return position == otherCar.position;
    }

    public int findMaxPosition(int otherPosition) {
        return Math.max(position, otherPosition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }

    @Override
    public String toString() {
        return toStringName() + ":" + toStringPosition();
    }

    private String toStringPosition() {
        return POSITION_MAKER.repeat(position);
    }

    public String toStringName() {
        return name;
    }
}
