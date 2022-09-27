package step3.car_racing.model;

public class Car {

    private static final String INIT_DISTANCE = "-";
    private static final String FORWARD_DISTANCE = "-";
    private String distance = INIT_DISTANCE;

    public String moveForward() {
        return this.distance = distance + FORWARD_DISTANCE;
    }

    public String getDistance() {
        return distance;
    }
}
