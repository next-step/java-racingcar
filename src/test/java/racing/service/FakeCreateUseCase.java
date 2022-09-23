package racing.service;

import racing.domain.car.CarRace;
import racing.domain.car.usecase.CreateUseCase;
import racing.dto.CarRaceDto;

public class FakeCreateUseCase implements CreateUseCase {

    @Override
    public CarRaceDto makeCars(int numberOfCar) {
        return new CarRaceDto(new CarRace(numberOfCar));
    }
}
