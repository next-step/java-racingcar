package racinggame.dto;

import racinggame.domain.Car;

/**
 * Created by seungwoo.song on 2022-09-26
 */
public class CarSnapshot {

    private String name;
    private int distance;

    public CarSnapshot(Car car) {
        this.name = car.name();
        this.distance = car.distance();
    }

    public String name() {
        return name;
    }

    public int distance() {
        return distance;
    }
}
