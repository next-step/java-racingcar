package javaracingcarwinner.entity;

public class RacingCar {
    private static final int DEFAULT_LOCATION = 0;
    private static final int DEFAULT_MOVE_VALUE = 1;
    private static final int MIN_STANDARDS_VALUE = 4;
    private static final int MAX_STANDARDS_VALUE = 9;

    private static final int MAX_NAME_LENGTH = 5;


    private final String name;

    private int location;

    public RacingCar(String name) {
        this(name, DEFAULT_LOCATION);
    }

    public RacingCar(String name, int location) {
        validateName(name);
        this.name = name;
        this.location = location;
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("5자 초과");
        }
    }

    public void move(MoveStrategy move) {
        if (isMove(move.movingValue())) {
            go();
        }
    }

    private RacingCar go() {
        location += DEFAULT_MOVE_VALUE;
        return this;
    }

    private boolean isMove(int value) {
        return MIN_STANDARDS_VALUE <= value && value <= MAX_STANDARDS_VALUE;
    }

    public String name() {
        return this.name;
    }

    public int location() {
        return this.location;
    }

    public int max(int maxLocation) {
        if (this.location > maxLocation) {
            return this.location;
        }
        return maxLocation;
    }

    public RacingCar currentLocationSave() {
        return new RacingCar(this.name, this.location);
    }
}
