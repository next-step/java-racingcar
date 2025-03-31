package racingcar.domain.dto;

import racingcar.domain.Car;

public class CarDto {
    private final String carName;
    private final int position;

    public CarDto(final String carName, final int position) {
        this.carName = carName;
        this.position = position;
    }


    public static CarDto toDto(Car car) {
        return new CarDto(car.getName(), car.getPosition());
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

}
