package car;

public class Car implements Comparable<Car> {
    private CarPosition carPosition;
    private final CarName carName;
    private static final int FORWARD_BOUNDARY_NUMBER = 4;

    public Car(int distance, String carName) {
        this.carPosition = new CarPosition(distance);
        this.carName = new CarName(carName);
    }

    public int getDistance() {
        return carPosition.getDistance();
    }

    public String getCarName() {
        return carName.getName();
    }

    public void game(int randomNumber) {
        if(isMovableForwardNumber(randomNumber)) {
            this.carPosition = new CarPosition(carPosition.getDistance() + 1);
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
