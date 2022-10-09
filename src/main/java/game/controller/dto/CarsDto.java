package game.controller.dto;

import game.domain.Cars;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarsDto {

    private final List<CarDto> carList;

    private CarsDto(final List<CarDto> carList) {
        this.carList = carList;
    }

    public static CarsDto from(final Cars cars) {
        return new CarsDto(cars.getCarList().stream()
                .map(CarDto::from)
                .collect(Collectors.toList()));
    }

    public List<CarDto> getCarList() {
        return Collections.unmodifiableList(carList);
    }
}
