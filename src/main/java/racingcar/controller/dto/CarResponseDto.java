package racingcar.controller.dto;

import racingcar.domain.Car;

public class CarResponseDto {

    private int numberOfMove = 0;

    private CarResponseDto(Car car) {
        this.numberOfMove = car.getNumberOfMove();
    }

    public static CarResponseDto of(Car car) {
        return new CarResponseDto(car);
    }

    public int getNumberOfMove() {
        return numberOfMove;
    }

}
