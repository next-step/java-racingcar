package racinggame.dto;

import racinggame.domain.Car;
import racinggame.domain.CarName;

public class WinCarsDTO {
    private CarName carName;

    public WinCarsDTO(Car car) {
        if (car == null) {
            new IllegalArgumentException("car는 null일수 없습니다.");
        }

        this.carName = car.getCarName();
    }

    public CarName getCarName() {
        return carName;
    }
}
