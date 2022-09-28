package racinggame.domain.car;

import racinggame.domain.exception.InvalidCarNameException;

public class Car {

    private static final int FORWARD_DISTANCE = 1;
    private static final int STANDSTILL = 0;
    private static final int FUEL_TO_MOVE = 4;
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final int MINIMUM_NAME_LENGTH = 1;

    private final String name;
    private int distance;

    public Car(String name) {
        validateCarNameLength(name);
        this.name = name;
        distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > MAXIMUM_NAME_LENGTH || carName.length() < MINIMUM_NAME_LENGTH) {
            throw new InvalidCarNameException();
        }
    }

    public void move(int fuel) {
        distance += getForwardDistance(fuel);
    }

    private int getForwardDistance(int fuel) {
        if (fuel >= FUEL_TO_MOVE) {
            return FORWARD_DISTANCE;
        }
        return STANDSTILL;
    }

}
