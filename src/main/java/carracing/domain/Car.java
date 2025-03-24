package carracing.domain;

public class Car {
    public static final int CAR_MOVING_BOUND = 4;

    private String name;
    private int distance = 1;

    public Car(String name) {
        this.name = name;
    }

    public void move(int randomNum) {
        if (randomNum >= CAR_MOVING_BOUND) {
            ++distance;
        }
    }

    public String makeDistanceString() {
        String distanceString = name + " : ";
        for (int i = 0; i < distance; ++i) {
            distanceString += "-";
        }
        return distanceString;
    }

    public String getName() {
        return name;
    }

    public boolean hasSameDistance(int maxDistance) {
        return distance == maxDistance;
    }

    public int returnMaxDistance(int maxDistance) {
        return Math.max(maxDistance, distance);
    }
}
