package racingcar.racing.model;

public class Car {
    private static final Integer MAX_NAME_LENGTH = 5;

    private final String carName;
    private int position = 0;

    public Car(String carName) {
        if (carName == null || carName.isBlank() || carName.length() > MAX_NAME_LENGTH)
            throw new IllegalArgumentException("Failed to create car instance. carName only allows values greater than or equal to 5");

        this.carName = carName;
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName;
    }

    public void move() {
        this.position++;
    }
}
