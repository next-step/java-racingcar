package car;

public class Car implements Comparable<Car> {
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

    public String getCarName() {
        return carName;
    }

    public void game(int randomNumber) {
        if(isMovableForwardNumber(randomNumber)) {
            carPosition.incrementDistance();
        }
    }

    private boolean isMovableForwardNumber(int randomNumber) {
        return randomNumber >= FORWARD_BOUNDARY_NUMBER;
    }

    @Override
    public int compareTo(Car otherCar) {
        return this.carPosition.compareTo(otherCar.carPosition);
    }

    public boolean isSameDistance(Car winnerCar) {
        return this.carPosition.isSameDistance(winnerCar.carPosition);
    }
}
