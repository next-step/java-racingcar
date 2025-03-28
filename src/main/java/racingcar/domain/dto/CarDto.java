package racingcar.domain.dto;

import racingcar.domain.Car;

public class CarDto {
    private final int position;

    public CarDto(final int position) {
        this.position = position;
    }

    public static CarDto toDto(Car car) {
        return new CarDto(car.getPosition());
    }

    public int getPosition() {
        return position;
    }

}
