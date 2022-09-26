package step3.car_racing.model;

public class Car {

    private static final Integer INIT_DISTANCE = 0;
    private static final Integer FORWARD_DISTANCE = 1;
    private Integer distance = INIT_DISTANCE;

    public Integer moveForward() {
        return this.distance = distance + FORWARD_DISTANCE;
    }

    public Integer getDistance() {
        return distance;
    }
}
