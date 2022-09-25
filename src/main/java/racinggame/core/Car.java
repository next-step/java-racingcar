package racinggame.core;

public class Car {

    private static final int FORWARD_DISTANCE = 1;
    private static final int STANDSTILL = 0;
    private static final int FUEL_TO_MOVE = 4;

    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
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
