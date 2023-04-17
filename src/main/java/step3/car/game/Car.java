package step3.car.game;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.Serializable;
import java.util.Objects;

public class Car implements Serializable {
    private static final int MOVE_NUMBER = 4;
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int START_LOCATION = 0;
    private int location;
    private String carName;

    public Car() {
        this(RandomStringUtils.randomAlphabetic(5));
    }

    public Car(String carName) {
        checkLength(carName);
        checkString(carName);
        this.location = START_LOCATION;
        this.carName = carName;
    }

    private void checkLength(String carName) {
        if (carName.length() > 5) {
            throw new RuntimeException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    private void checkString(String carName) {
        if (Objects.isNull(carName) || carName.isBlank() || carName.isEmpty()) {
            throw new RuntimeException("올바르지 않은 문자열 입니다.");
        }
    }

    public void move(int input) {
        if (isMovable(input)) {
            this.location++;
        }
    }

    private boolean isMovable(int input) {
        if (input < MIN_NUMBER || input > MAX_NUMBER) {
            throw new RuntimeException("유효하지 않은 숫자입니다.");
        }
        return input >= MOVE_NUMBER;
    }

    public int location() {
        return location;
    }

    public String name() {
        return carName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return location == car.location && Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, carName);
    }
}
