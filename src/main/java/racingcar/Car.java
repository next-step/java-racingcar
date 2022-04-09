package racingcar;

public class Car {

    private final CurrentLocation currentLocation = new CurrentLocation();

    public int move(int number) {
        if(currentLocation.meetsMovementRule(number)) {
            currentLocation.moveForward();
        }
        return currentLocation.getLocationValue();
    }

    public int getCurrentLocation() {
        return currentLocation.getLocationValue();
    }

}
