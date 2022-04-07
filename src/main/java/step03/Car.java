package step03;

public class Car {

    public static final int MOVEMENT_RULE_NUMBER = 4;

    private int currentLocation;

    public Car() {
        this.currentLocation = 1;
    }

    public int move(int number) {
        if(meetsMovementRule(number)) {
            this.currentLocation += 1;
        }
        return currentLocation;
    }

    private boolean meetsMovementRule(int number) {
        return number >= MOVEMENT_RULE_NUMBER;
    }

    public int getCurrentLocation() {
        return currentLocation;
    }

}
