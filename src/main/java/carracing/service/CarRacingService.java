package carracing.service;

import carracing.model.Cars;
import carracing.model.ui.InputDto;

public class CarRacingService {

    private final Cars cars;

    private final Integer tryCount;

    public CarRacingService(InputDto dto) {
        this.cars = Cars.from(dto.getName());
        this.tryCount = dto.getTryCount();
    }

    public Cars gameStart() {
        for (int i = 0; i < tryCount; i++) {
            cars.carsRace();
        }

        return cars;
    }

}
