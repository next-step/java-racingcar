package racingcar.model;

public class CurrentLocation {

    private int locationValue = 1;

    public void moveForward() {
        locationValue += 1;
    }

    public int getLocationValue() {
        return locationValue;
    }
}
