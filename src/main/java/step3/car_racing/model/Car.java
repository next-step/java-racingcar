package step3.car_racing.model;

import static step3.car_racing.util.RandomUtil.isForward;

public class Car {

    private static final String INIT_DISTANCE = "-";
    private static final String FORWARD_DISTANCE = "-";
    private String distance = INIT_DISTANCE;

    public void moveForward() {
        if (isForward()) {
            this.distance = distance + FORWARD_DISTANCE;
        }
        System.out.println(this.distance);
    }

    public String getDistance() {
        return distance;
    }
}
