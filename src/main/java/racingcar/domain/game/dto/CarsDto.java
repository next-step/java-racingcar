package racingcar.domain.game.dto;

import java.util.List;
import java.util.Objects;

public class CarsDto {
    private final List<CarDto> cars;

    public CarsDto(List<CarDto> cars) {
        this.cars = cars;
    }

    public List<CarDto> getCars() {
        return cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarsDto)) return false;

        CarsDto carsDto = (CarsDto) o;

        return Objects.equals(cars, carsDto.cars);
    }

    @Override
    public int hashCode() {
        return cars != null ? cars.hashCode() : 0;
    }
}
