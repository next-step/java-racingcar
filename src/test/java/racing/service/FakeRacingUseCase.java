package racing.service;

import racing.domain.car.CarRace;
import racing.domain.car.usecase.RacingUseCase;
import racing.dto.CarRaceDto;

public class FakeRacingUseCase implements RacingUseCase {

    @Override
    public CarRaceDto racingGame(CarRaceDto carRaceDto) {
        CarRace carRace = carRaceDto.toEntity();
        carRace.move();
        return carRaceDto.fromEntity(carRace);
    }
}
