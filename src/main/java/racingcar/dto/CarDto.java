package racingcar.dto;

import racingcar.car.Car;

public class CarDto {
    private final int position;

    public CarDto(int position) {
        this.position = position;
    }

    public static CarDto from(Car car) {
        return new CarDto(car.currentPosition());
    }

    public int getPosition() {
        return position;
    }
}
