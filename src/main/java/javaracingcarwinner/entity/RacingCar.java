package javaracingcarwinner.entity;

public class RacingCar {

    private static final int DEFAULT_LOCATION = 0;
    private static final int DEFAULT_MOVE_VALUE = 1;
    private static final int MIN_STANDARDS_VALUE = 4;
    private static final int MAX_STANDARDS_VALUE = 9;

    private final String name;

    private int location = DEFAULT_LOCATION;

    public RacingCar(String name) {
        this.name = name;
    }

    public RacingCar go() {
        location += DEFAULT_MOVE_VALUE;
        return this;
    }

    public boolean isMove(int value) {
        if (MIN_STANDARDS_VALUE <= value && value <= MAX_STANDARDS_VALUE) {
            return true;
        }
        return false;
    }

    public String name() {
        return this.name;
    }

    public int location() {
        return this.location;
    }
}
