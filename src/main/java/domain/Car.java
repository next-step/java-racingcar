package domain;

public class Car {
    private final String name;
    private int distance;
    private static final int CAR_NAME_LENGTH_BOUND = 5;
    private static final int CAR_MOVE_CONDITION = 4;

    public Car(String name, int distance) {
        validateNameLengthCheck(name);
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void updateDistance(int randomNumber) {
        if (randomNumber >= CAR_MOVE_CONDITION) {
            this.distance += 1;
        }
    }

    public void validateNameLengthCheck(final String name) {
        if (name.length() > CAR_NAME_LENGTH_BOUND) {
            throw new IllegalArgumentException("car name is too long");
        }
    }
}
