package racingcar.controller.dto;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Distance;
import racingcar.domain.Name;

import java.util.List;
import java.util.stream.Collectors;

public class CarResponseDto {

    private Name name;
    private Distance numberOfMove;

    private CarResponseDto(Car car) {
        this.name = car.getName();
        this.numberOfMove = car.getDistance();
    }

    public static CarResponseDto toDto(Car car) {
        return new CarResponseDto(car);
    }

    public static List<CarResponseDto> toDtos(Cars cars) {
        return cars.getCars()
                .stream()
                .map(CarResponseDto::toDto)
                .collect(Collectors.toList());
    }

    public Distance getDistance() {
        return this.numberOfMove;
    }

    public Name getName() {
        return this.name;
    }
}
