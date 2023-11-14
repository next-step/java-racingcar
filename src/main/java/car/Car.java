package car;

import java.util.Objects;

public class Car {
    private static final int START_DISTANCE = 0;
    private static final int FORWARD_BOUNDARY_NUMBER = 4;
    private CarPosition carPosition;
    private final CarName carName;

    public Car(String carName) {
        this.carPosition = new CarPosition(START_DISTANCE);
        this.carName = new CarName(carName);
    }

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

    public int compareToDistance(Car otherCar) {
        return this.carPosition.compareTo(otherCar.carPosition);
    }

    public boolean isSameDistance(Car winnerCar) {
        return this.carPosition.isSameDistance(winnerCar.carPosition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(carPosition, car.carPosition) && Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carPosition, carName);
    }
}
