package carracing.domain;

public class Car {

    private static final int START_POSITION = 1;
    private static final int MOVE_FORWARD_BASIS = 4;

    private final CarStatus carStatus;

    public Car(String name) {
        this.carStatus = new CarStatus(name, START_POSITION);
    }

    public void moveForwardIfNumberValid(int randomNumber) {
        if (randomNumber >= MOVE_FORWARD_BASIS) {
            carStatus.increasePosition();
        }
    }

    public CarStatus getCarStatus() {
        return new CarStatus(carStatus.getName(), carStatus.getPosition());
    }
}
