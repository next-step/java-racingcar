package domain;

public class RacingCarPosition {
    private String name;
    private Integer locationPoint;

    public RacingCarPosition(String name, Integer locationPoint) {
        this.name = name;
        this.locationPoint = locationPoint;
    }

    public String getName() {
        return name;
    }

    public Integer getLocationPoint() {
        return locationPoint;
    }
}
