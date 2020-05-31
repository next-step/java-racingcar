package autoracing;

public class Movement {
    public static Movement STATIONARY = new Movement(0);
    public static Movement ONE_FORWARD = new Movement(1);
    public static Movement from(int distance) {
        if (distance == 0) {
            return STATIONARY;
        }
        if (distance == 1) {
            return ONE_FORWARD;
        }
        return new Movement(distance);
    }

    private int distance;

    private Movement(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }
}
