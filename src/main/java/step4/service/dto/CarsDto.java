package step4.service.dto;

import step4.domain.Cars;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CarsDto {

    private final List<CarDto> carDtos;

    private CarsDto(List<CarDto> carDtos) {
        this.carDtos = carDtos;
    }

    public static CarsDto of(Cars cars) {
        List<CarDto> carDtos = cars.getCars().stream()
                .map(CarDto::of)
                .collect(Collectors.toList());
        return new CarsDto(carDtos);
    }

    public List<CarDto> getCarDtos() {
        return carDtos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarsDto carsDto = (CarsDto) o;
        return Objects.equals(carDtos, carsDto.carDtos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carDtos);
    }

    @Override
    public String toString() {
        return "CarsDto{" +
                "carDtos=" + carDtos +
                '}';
    }
}
