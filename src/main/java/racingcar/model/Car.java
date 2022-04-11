package racingcar.model;

public class Car {

    private final CurrentLocation currentLocation = new CurrentLocation();

    private final CarName carName;

    private Car(String carName) {
        this.carName = new CarName(carName);
    }

    public static Car from(String carName) {
        return new Car(carName);
    }

    public int move(int number) {
        if(currentLocation.meetsMovementRule(number)) {
            currentLocation.moveForward();
        }
        return currentLocation.getLocationValue();
    }

    public CarName getCarName() {
        return carName;
    }

    public String getCarNameValue() {
        return carName.getName();
    }

    public int getCurrentLocationValue() {
        return currentLocation.getLocationValue();
    }

    public boolean isMaxMovement(int value) {
        return getCurrentLocationValue() == value;
    }

    public int isForwardLocationThan(Car car) {
        if(this.getCurrentLocationValue() >= car.getCurrentLocationValue()) {
            return 1;
        }
        return -1;
    }
}
