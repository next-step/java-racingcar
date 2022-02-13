package racingcar.domain;

public class Car {

    private final String name;
    private int distance;
    private static final int MOVE_THRESHOLD = 4;
    private static final int LIMIT_NAME_LENGTH = 5;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int distance) {
        validateCarName(name);
        this.name = name;
        this.distance = distance;
    }

    public static void validateCarName(String carName) {
        if (carName.length() > LIMIT_NAME_LENGTH) {
            throw new IllegalArgumentException("Error: Invalid car name");
        }
    }

    public void moveCarRandomly(int randomNumber) {
        if (randomNumber >= MOVE_THRESHOLD) {
            this.distance++;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
