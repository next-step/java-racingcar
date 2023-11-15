package racing.domain;

public class Car {

    private static final int ACCEPT_MOVE_NUMBER = 4;

    private CarName carName;
    private CarPosition carPosition;

    public Car(CarName carName, final CarPosition carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public CarName getCarName() {
        return carName;
    }

    public CarPosition getCarPosition() {
        return carPosition;
    }

    public void tryMove(int number) {
        if (number >= ACCEPT_MOVE_NUMBER) {
            carPosition.movePosition();
        }
    }
}
