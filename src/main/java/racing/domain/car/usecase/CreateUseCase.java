package racing.domain.car.usecase;

import racing.dto.CarRaceDto;

public interface CreateUseCase {

    CarRaceDto makeCars(int numberOfCar);
}
