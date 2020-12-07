package racingcar;

public class Car {
    private static final int INITIAL_LOCATION = 1;
    private static final int MOVE_CONDITION = 4;
    int location;
    int state;

    public Car() {
        this.location = INITIAL_LOCATION;
    }

    public int getLocation() {
        return this.location;
    }

    public int getLocation(int randomNumber) {
        if(randomNumber >= MOVE_CONDITION) {
            return this.location += 1;
        }
        return this.location;
    }
}
