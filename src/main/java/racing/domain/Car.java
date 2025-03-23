package racing.domain;

import racing.data.Messages;

public class Car {

    public static final int MOVE_THRESHOLD = 4;
    public static final int CAR_NAME_THRESHOLD = 5;

    private final Position position;
    private String carName;

    public Car() {
        this.position = new Position(0);
    }

    public Car(String carName, int position) {
        this.carName = carName;
        this.position = new Position(position);
    }

    public Car(String carName) {
        if (carName == null || carName.isBlank() || carName.length() > CAR_NAME_THRESHOLD) {
            throw new IllegalArgumentException(Messages.ERROR_CAR_NAME_LENGTH);
        }
        this.position = new Position(0);
        this.carName = carName;
    }

    public int getPosition() {
        return this.position.getValue();
    }

    public String getCarName() {
        return this.carName;
    }

    public void move(int randomNumber) {
        if (isMovable(randomNumber)) this.position.increase();
    }

    public boolean isMovable(int randomNumber) {
        return randomNumber >= MOVE_THRESHOLD;
    }

    public int max(int maxPosition) {
        return this.position.max(maxPosition);
    }

    public boolean isSamePosition(int position) {
        return this.position.equals(new Position(position));
    }
}
