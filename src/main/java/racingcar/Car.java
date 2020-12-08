package racingcar;

public class Car {
    private static final int INITIAL_LOCATION = 1;
    private static final int MOVE_CONDITION = 4;
    int location;

    public Car() {
        this.location = INITIAL_LOCATION;
    }

    public void setLocation(int randomNumber) {
        if(randomNumber >= MOVE_CONDITION) {
            this.location += 1;
        }
    }

    public int getLocation() {
        return this.location;
    }
}
