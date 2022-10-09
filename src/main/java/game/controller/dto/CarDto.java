package game.controller.dto;

import game.domain.Car;

public class CarDto {

    private final int position;

    private final String carName;

    public CarDto(final int position, final String carName) {
        this.position = position;
        this.carName = carName;
    }

    public static CarDto from(final Car car) {
        return new CarDto(car.getPosition().getPosition(), car.getCarName().getName());
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName;
    }
}
