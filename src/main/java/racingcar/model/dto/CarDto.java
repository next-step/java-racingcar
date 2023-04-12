package racingcar.model.dto;

import racingcar.model.Car;

public class CarDto {
    private final int distance;

    private CarDto(int distance) {
        this.distance = distance;
    }

    public static CarDto from(Car car) {
        return new CarDto(car.distance());
    }

    public int distance() {
        return distance;
    }
}
