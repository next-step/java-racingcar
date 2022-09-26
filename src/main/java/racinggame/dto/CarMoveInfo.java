package racinggame.dto;

import racinggame.domain.Car;

/**
 * Created by seungwoo.song on 2022-09-26
 */
public class CarMoveInfo {
    private int distance;

    public CarMoveInfo(Car car) {
        this.distance = car.distance();
    }

    public int distance() {
        return distance;
    }
}
