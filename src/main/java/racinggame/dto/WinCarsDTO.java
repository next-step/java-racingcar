package racinggame.dto;

import racinggame.domain.Car;

public class WinCarsDTO {
    private String name;

    public WinCarsDTO(Car car) {
        if (car == null) {
            new IllegalArgumentException("car는 null일수 없습니다.");
        }

        this.name = car.name();
    }

    public String getName() {
        return name;
    }
}
