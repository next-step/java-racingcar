package racing.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racing.domain.CarRace;
import racing.dto.CarDto;
import racing.dto.CarRaceDto;

public class RacingService {

    public CarRaceDto racingGame(CarRaceDto carRaceDto) {
        CarRace carRace = carRaceDto.toEntity();
        carRace.move();
        return carRaceDto.fromEntity(carRace);
    }

    public CarRaceDto makeCars(int numberOfCars) {
        List<CarDto> carDtoList = IntStream.range(0, numberOfCars)
            .mapToObj(__ -> new CarDto())
            .collect(Collectors.toList());
        return new CarRaceDto(carDtoList);
    }

}
