package domain;

public class Car {
    private final String name;
    private int distance;
    static final int CAR_NAME_LENGTH_BOUND = 5;

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

    public void updateDistance() {
        this.distance += 1;
    }

    public void validateNameLengthCheck(final String name) {
        if (name.length() > CAR_NAME_LENGTH_BOUND) {
            throw new IllegalArgumentException("car name is too long");
        }
    }
}
