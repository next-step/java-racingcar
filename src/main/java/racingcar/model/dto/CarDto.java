package racingcar.model.dto;

import racingcar.model.car.Car;

public class CarDto {
    private final int distance;
    private final String name;

    private CarDto(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public static CarDto from(Car car) {
        return new CarDto(car.name(), car.distance().intValue());
    }

    public String name() {
        return name;
    }

    public int distance() {
        return distance;
    }
}
