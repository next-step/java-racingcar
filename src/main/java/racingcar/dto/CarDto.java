package racingcar.dto;

import racingcar.car.Car;

import java.util.Objects;

public class CarDto {
    private final int position;

    private CarDto(Car car) {
        validate(car);

        this.position = car.currentPosition();
    }

    private void validate(Car car) {
        if (Objects.isNull(car)) {
            throw new IllegalArgumentException("Car can't be null");
        }
    }

    public static CarDto from(Car car) {
        return new CarDto(car);
    }

    public int getPosition() {
        return position;
    }
}
