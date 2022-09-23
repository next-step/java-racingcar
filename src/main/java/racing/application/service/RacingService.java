package racing.application.service;

import racing.domain.car.CarRace;
import racing.domain.car.usecase.CreateUseCase;
import racing.domain.car.usecase.RacingUseCase;
import racing.dto.CarRaceDto;

public class RacingService implements CreateUseCase, RacingUseCase {

    @Override
    public CarRaceDto makeCars(int numberOfCars) {
//        List<CarDto> carDtoList = IntStream.range(0, numberOfCars)
//            .mapToObj(__ -> new CarDto())
//            .collect(Collectors.toList());
//
//        return new CarRaceDto(carDtoList);

        return new CarRaceDto(new CarRace(numberOfCars));
    }

    @Override
    public CarRaceDto racingGame(CarRaceDto carRaceDto) {
        CarRace carRace = carRaceDto.toEntity();
        carRace.move();
        return carRaceDto.fromEntity(carRace);
    }

}
