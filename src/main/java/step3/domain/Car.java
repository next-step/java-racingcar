package step3.domain;

public class Car {
    private static final int INITIAL_LOCATION = 0;
    private static final int MOBILITY_JUDGMENT_NUMBER = 4;
    private int location;

    public Car() {
        this.location = INITIAL_LOCATION;
    }

    public int getLocation() {
        return location;
    }

    public void move(int randomNum) {
        if (randomNum >= MOBILITY_JUDGMENT_NUMBER) {
            this.location++;
        }
    }
}
