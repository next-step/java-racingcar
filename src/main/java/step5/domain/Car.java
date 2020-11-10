package step5.domain;

import step5.exception.ValidateBlankName;
import step5.exception.ValidateLengthOfCarName;
import step5.utils.RandomUtil;

import java.util.Objects;

public class Car {
    private final static int LIMIT_LENGTH_CAR_NAME = 5;
    private final static int MIN_MOVE_CONDITION = 4;
    private int position = 0;
    private final String name;

    public Car(String name) {
        validateLengthOfCarName(name);
        validateBlankName(name);

        this.name = name;
    }

    private void validateLengthOfCarName(String name) {
        if (name.length() > LIMIT_LENGTH_CAR_NAME) {
            throw new ValidateLengthOfCarName(LIMIT_LENGTH_CAR_NAME);
        }
    }

    private void validateBlankName(String name) {
        if (name.trim().length() == 0) {
            throw new ValidateBlankName();
        }
    }

    public void move(int moveCondition) {
        if (moveCondition >= MIN_MOVE_CONDITION) {
            position++;
        }
    }

    public int getPosition() {
        return this.position;
    }


    @Override
    public String toString() {
        return name;
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
        return Objects.hash(position, name);
    }
}
