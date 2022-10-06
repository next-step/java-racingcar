package game.controller.dto;

import game.model.Car;

public class CarDto {

    private final int position;

    private final String carName;

    private CarDto(int position, String carName) {
        this.position = position;
        this.carName = carName;
    }

    public static CarDto from(Car car) {
        return new CarDto(car.getPosition().getPosition(), car.getCarName().getName());
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName;
    }
}
