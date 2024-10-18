package racingcar.domain;

public class Car {

    private static final int MOVE_CONDITION = 4;

    private final CarName carName;
    private final CarPosition carPosition;

    public Car(CarName name, CarPosition position) {
        this.carName = name;
        this.carPosition = position;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_CONDITION) {
            carPosition.move();
        }
    }

    public String getName() {
        return carName.getName();
    }

    public int getCurrentPosition() {
        return carPosition.getCurrentPosition();
    }

    public boolean isAtPosition(int position) {
        return carPosition.getCurrentPosition() == position;
    }
}
