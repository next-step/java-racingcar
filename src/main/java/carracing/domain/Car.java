package carracing.domain;

import carracing.exception.RacingCarIllegalArgumentException;
import util.StringUtil;

import java.util.Objects;

public class Car {
    private static final int ALLOWED_MAXIMUM_NAME_LENGTH = 5;
    private static final int DEFAULT_POSITION = 1;
    private static final int ALLOWED_MINIMUM_DISTANCE = 4;

    private final String name;
    private final int position;

    private Car(String name, int position) {
        this.position = position;
        this.name = name;
    }

    public static Car of(String name, int position) {
        return new Car(name, position);
    }

    public static Car from(String name) {
        if (StringUtil.isBlank(name) || name.length() > ALLOWED_MAXIMUM_NAME_LENGTH) {
            throw RacingCarIllegalArgumentException.INVALID_NAME_LENGTH;
        }
        return new Car(name, DEFAULT_POSITION);
    }

    public Car move(int randomNumber) {
        if (canMove(randomNumber)) {
            return new Car(name, position + 1);
        }
        return new Car(name, position);
    }

    public boolean isPositionEqualTo(int position) {
        return this.position == position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    private boolean canMove(int distance) {
        return distance >= ALLOWED_MINIMUM_DISTANCE;
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
        return Objects.hash(name, position);
    }

}
