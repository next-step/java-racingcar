package racingcar.domain;

public class Car {

    private final CarName carName;
    private final CarPosition carPosition;

    public Car(CarName name, CarPosition position) {
        this.carName = name;
        this.carPosition = position;
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
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
