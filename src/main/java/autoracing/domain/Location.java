package autoracing.domain;

public class Location {
    public static Location STARTING_LINE = new Location(0);

    private final int distance;

    Location(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public Location move(int movement) {
        return new Location(this.distance + movement);
    }
}
