package racingcar.controller.dto;

import racingcar.domain.Car;
import racingcar.domain.Name;

import java.util.List;
import java.util.stream.Collectors;

public class CarResponseDto {

    private Name name;
    private int numberOfMove;

    private CarResponseDto(Car car) {
        this.name = car.getName();
        this.numberOfMove = car.getNumberOfMove();
    }

    public static CarResponseDto toDto(Car car) {
        return new CarResponseDto(car);
    }

    public static List<CarResponseDto> toDtos(List<Car> cars) {
        return cars.stream()
                .map(CarResponseDto::toDto)
                .collect(Collectors.toList());
    }

    public int getNumberOfMove() {
        return numberOfMove;
    }

    public Name getName() {
        return name;
    }
}
