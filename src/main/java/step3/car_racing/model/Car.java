package step3.car_racing.model;

import step3.car_racing.util.MovingStrategy;

public class Car {

    private static final String INIT_DISTANCE = "-";
    private static final String FORWARD_DISTANCE = "-";
    private String distance = INIT_DISTANCE;
    private String name;

    public Car initCar(String name) {
        this.name = name;
        return this;
    }

    public Car resultCar(String name, String distance) {
        this.name = name;
        this.distance = distance;
        return this;
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            this.distance = distance + FORWARD_DISTANCE;
        }
    }

    public String getDistance() {
        return this.distance;
    }

    public Integer getDistanceLength() {
        return this.distance.length();
    }

    public String getName() {
        return this.name;
    }
}
