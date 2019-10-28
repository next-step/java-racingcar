package racingcar;

public class Car {

    private static final int INIT_LOCATION = 0;
    private static final int MOVE_CONDITION_NUMBER = 4;

    private int location;

    public Car() {
        initializeLocation(INIT_LOCATION);
    }

    public Car(int location) {
        initializeLocation(location);
    }

    private void initializeLocation(int location) {
        this.location = location;
    }

    void move(int number) {

        if (isPossibleMove(number)) {
            this.location++;
        }
    }

    private boolean isPossibleMove(int number) {
        return number >= MOVE_CONDITION_NUMBER;
    }

    int getLocation() {
        return location;
    }
}
