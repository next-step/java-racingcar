package racingcar.model;

public class CurrentLocation {

    private static final int MOVEMENT_RULE_NUMBER = 4;

    private int locationValue = 1;

    public void moveForward() {
        locationValue += 1;
    }

    public boolean meetsMovementRule(int number) {
        return number >= MOVEMENT_RULE_NUMBER;
    }

    public int getLocationValue() {
        return locationValue;
    }
}
