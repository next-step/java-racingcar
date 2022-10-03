package racinggame.dto;

import racinggame.domain.Car;
import racinggame.domain.embeded.CarName;

public class WinCarsDTO {
    private CarName carName;

    public WinCarsDTO(Car car) {
        if (car == null) {
            throw new IllegalArgumentException("car는 null일수 없습니다.");
        }

        this.carName = car.getCarName();
    }

    public CarName getCarName() {
        return carName;
    }
}
