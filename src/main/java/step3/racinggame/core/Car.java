package step3.racinggame.core;

public class Car {

    private static final int FORWARD_DISTANCE = 1;
    private static final int STANDSTILL = 0;
    private static final int FUEL_TO_MOVE = 4;

    private int distance;

    public Car() {
        distance = 0;
    }

    public int getDistance() {
        return distance;
    }

    public void move(int fuel) {
        distance += assureDistance(fuel);
    }

    private int assureDistance(int fuel) {
        if (fuel >= FUEL_TO_MOVE) {
            return FORWARD_DISTANCE;
        }
        return STANDSTILL;
    }

}
