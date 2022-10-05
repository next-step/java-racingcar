package dto;

public class RacingCarInfo {
    private int distance;
    private String name;

    public RacingCarInfo(int distance) {
        this.distance = distance;
    }

    public RacingCarInfo(int distance, String name) {
        this.distance = distance;
        this.name = name;
    }

    public int plusDistance() {
        distance += 1;
        return distance;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}
