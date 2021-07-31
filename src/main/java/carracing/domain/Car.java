package carracing.domain;

public class Car {

    private static final int START_POSITION = 1;
    private static final int MOVE_FORWARD_BASIS = 4;

    private final CarName carName;
    private int position;

    public Car(CarName carName) {
        this.carName = carName;
        this.position = START_POSITION;
    }

    public void moveForwardIfNumberValid(int randomNumber) {
        if (randomNumber >= MOVE_FORWARD_BASIS) {
            position++;
        }
    }

    public CarStatus getCarStatus() {
        return new CarStatus(carName, position);
    }
}
