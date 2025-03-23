package racing.service;

import java.util.List;
import racing.domain.Cars;
import racing.domain.MovingStrategy;

public class RaceService {
    private final MovingStrategy movingStrategy;

    public RaceService(MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
    }

    public Cars generateCar(List<String> carNames) {
        return Cars.create(carNames);
    }

    public Cars moveCar(Cars cars) {
        return cars.movedAll(movingStrategy);
    }
}
