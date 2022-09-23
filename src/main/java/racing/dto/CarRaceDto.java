package racing.dto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import racing.domain.car.Car;
import racing.domain.car.CarRace;
import racing.domain.generator.DefaultNumberGenerator;

public class CarRaceDto {

    private final List<CarDto> carDtoList;

    public CarRaceDto(List<CarDto> dtoList) {
        this.carDtoList = dtoList;
    }

    public CarRaceDto(CarRace carRace) {
        this(carListToCarDto(carRace));
    }

    public List<CarDto> carRace() {
        return carDtoList;
    }

    public int size() {
        return this.carDtoList.size();
    }

    public CarRaceDto fromEntity(CarRace carRace) {
        List<CarDto> dtoList = carListToCarDto(carRace);
        return new CarRaceDto(dtoList);
    }

    private static List<CarDto> carListToCarDto(CarRace carRace) {
        return carRace.cars().stream()
            .map(CarDto::new)
            .collect(Collectors.toList());
    }

    public CarRace toEntity() {
        List<Car> carList = this.carDtoList
            .stream()
            .map(CarDto::toEntity)
            .collect(Collectors.toList());
        return new CarRace(carList, new DefaultNumberGenerator());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarRaceDto that = (CarRaceDto) o;
        return Objects.equals(carDtoList, that.carDtoList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carDtoList);
    }
}
