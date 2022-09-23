package racing.dto;

import java.util.List;
import java.util.stream.Collectors;
import racing.domain.CarRace;
import racing.domain.DefaultNumberGenerator;
import racing.domain.car.Car;

public class CarRaceDto {

    private final List<CarDto> carDtoList;

    public CarRaceDto(List<CarDto> dtoList) {
        this.carDtoList = dtoList;
    }

    public List<CarDto> carRace() {
        return carDtoList;
    }

    public CarRaceDto fromEntity(CarRace carRace) {
        List<CarDto> dtoList = carRace.cars().stream()
            .map(CarDto::new)
            .collect(Collectors.toList()
            );
        return new CarRaceDto(dtoList);


    }

    public CarRace toEntity() {
        List<Car> carList = this.carDtoList
            .stream()
            .map(CarDto::toEntity)
            .collect(Collectors.toList());
        return new CarRace(carList, new DefaultNumberGenerator());
    }

}
