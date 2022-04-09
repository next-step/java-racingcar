package racingcar;

public class Car {

    private final CurrentLocation currentLocation = new CurrentLocation();

    private final CarName carName;

    public Car(String carName) {
        this.carName = new CarName(carName);
    }

    public int move(int number) {
        if(currentLocation.meetsMovementRule(number)) {
            currentLocation.moveForward();
        }
        return currentLocation.getLocationValue();
    }

    public int getCurrentLocation() {
        return currentLocation.getLocationValue();
    }

    public String getCarName() {
        return carName.getName();
    }

}
