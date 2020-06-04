package autoracing;

public class Location {
    public static Location STARTING_LINE = new Location(0, 0);

    private final int distance;
    private final int round;

    Location(int distance, int round) {
        this.distance = distance;
        this.round = round;
    }

    public int getDistance() {
        return distance;
    }

    public int getRound() {
        return round;
    }

    public Location move(int movement) {
        return new Location(this.distance + movement, this.round + 1);
    }
}
