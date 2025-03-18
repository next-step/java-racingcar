package racing.entity;

import java.util.Objects;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private int position = 1;
    private String carName;

    public Car() {
    }

    public Car(String carName) {
        registerName(carName);
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName;
    }

    public void move() {
        position++;
    }

    public void registerName(String carName) {
        if (checkNameLength(carName)) {
            this.carName = carName;
        }
    }

    private boolean checkNameLength(String carName) {
        int carNameLength = carName.length();

        if (carNameLength > MAX_NAME_LENGTH) {
            String messageFormat = "자동차 이름은 5자 이하여야 합니다. 입력값 : %s(%d자)";
            throw new IllegalArgumentException(String.format(messageFormat, carName, carNameLength));
        }

        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(carName, car.carName);
    }

}
