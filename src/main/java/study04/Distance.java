package study04;

public class Distance {

    private int distance;

    private Distance(int initDistance) {
        this.distance = initDistance;
    }

    public static Distance createDistance() {
        return createDistance(1);
    }

    public static Distance createDistance(int initDistance) {
        return new Distance(initDistance);
    }

    public void addDistance() {
        this.distance++;
    }

    public int totalDistance() {
        return this.distance;
    }

}
