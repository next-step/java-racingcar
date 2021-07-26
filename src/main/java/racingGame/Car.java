package racingGame;

import java.util.Objects;

public class Car {

    public static final int MOVABLE_LIMIT_NUMBER = 4;
    public static final int MAXIMUM_CAR_NAME_LENGTH = 5;
    public static final int DEFAULT_CAR_DISTANCE = 0;
    public static final String VALID_CAR_NAME_MESSAGE = "자동차 이름은" + MAXIMUM_CAR_NAME_LENGTH + "자를 초과할 수 없습니다.";

    private final String name;
    private final int distance;

    public Car(String name) {
        this(name, DEFAULT_CAR_DISTANCE);
    }

    public Car(String name, int distance) {
        validName(name);
        validDistance(distance);
        this.name = name;
        this.distance = distance;
    }

    private void validName(String name) {
        if (name.length() > MAXIMUM_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(VALID_CAR_NAME_MESSAGE);
        }
    }

    private void validDistance(int distance) {
        if (distance < DEFAULT_CAR_DISTANCE)
            throw new IllegalArgumentException("거리는 음수가 될 수 없습니다.");
    }

    public Car move(int random) {
        if (random >= MOVABLE_LIMIT_NUMBER) {
            return new Car(name, distance + 1);
        }
        return this;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public boolean equalsDistance(int distance) {
        return this.distance == distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return distance == car.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }

}
