package racinggame.dto;

import racinggame.domain.Car;
import racinggame.domain.embeded.CarDistance;
import racinggame.domain.embeded.CarName;

/**
 * Created by seungwoo.song on 2022-09-26
 */
public class CarSnapshot {

    private CarName carName;
    private CarDistance carDistance;

    public CarSnapshot(Car car) {
        this.carName = car.getCarName();
        this.carDistance = car.getCarDistance();
    }

    public CarName name() {
        return carName;
    }

    public CarDistance getCarDistance() {
        return carDistance;
    }
}
