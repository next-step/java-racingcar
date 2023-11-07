package car;

public class Car {
    private final CarPosition carPosition;
    private final String carName;
    private static final int FORWARD_BOUNDARY_NUMBER = 4;

    public Car(int distance, String carName) {
        this.carPosition = new CarPosition(distance);
        this.carName = carName;
    }

    public int getDistance() {
        return carPosition.getDistance();
    }

    public void game(int randomNumber) {
        if(isMovableForwardNumber(randomNumber)) {
            carPosition.incrementDistance();
        }
    }

    private boolean isMovableForwardNumber(int randomNumber) {
        return randomNumber >= FORWARD_BOUNDARY_NUMBER;
    }
}
