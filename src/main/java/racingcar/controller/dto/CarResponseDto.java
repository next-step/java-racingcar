package racingcar.controller.dto;

import racingcar.domain.Car;

public class CarResponseDto {

    private String name;
    private int numberOfMove = 0;

    private CarResponseDto(Car car) {
        this.name = car.getName();
        this.numberOfMove = car.getNumberOfMove();
    }

    public static CarResponseDto of(Car car) {
        return new CarResponseDto(car);
    }

    public int getNumberOfMove() {
        return numberOfMove;
    }

    public String getName() {
        return name;
    }
}
