package domain;

import util.RandomGenerator;

public class Car {
    private int distance = 0;
    private final int maxDistance;
    private final int bound;
    private final int condition;

    public Car(int maxDistance, int bound, int condition) {
        this.maxDistance = maxDistance;
        this.bound = bound;
        this.condition = condition;
    }

    public void move() {
        if (isCanMove()) {
            distance += 1;
        }
    }

    private boolean isCanMove() {
        return distance < maxDistance &&
                RandomGenerator.getCarRandomInt(bound) >= condition;
    }
    public String distanceToString() {
        return "-".repeat(Math.max(0, distance));
    }
}
