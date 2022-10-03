package racinggame.dto;

import racinggame.domain.Car;
import racinggame.domain.CarName;

/**
 * Created by seungwoo.song on 2022-09-26
 */
public class CarSnapshot {

    private CarName name;
    private int distance;

    public CarSnapshot(Car car) {
        this.name = car.getCarName();
        this.distance = car.distance();
    }

    public CarName name() {
        return name;
    }

    public int distance() {
        return distance;
    }
}
