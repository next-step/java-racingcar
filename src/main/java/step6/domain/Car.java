package step6.domain;

import java.util.Objects;

public class Car {
    private static final String MAX_CARNAME_LENGTH_ERROR_MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다.";
    private static final int MAX_CARNAME_LEGNTH = 5;
    private static final int MOVE_THRETHOLD = 4;

    private final String carName;

    private int position;

    public Car(String carName) {
        this(carName, 1);
    }

    public Car(String carName, int position) {
        validCarName(carName);
        this.carName = carName;
        this.position = position;
    }

    private void validCarName(String carName) {
        if (carName.length() > MAX_CARNAME_LEGNTH) {
            throw new IllegalArgumentException(MAX_CARNAME_LENGTH_ERROR_MESSAGE);
        }
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_THRETHOLD) {
            this.position++;
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }
}
