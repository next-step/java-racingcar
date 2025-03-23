package racing.service;

import java.util.List;
import racing.domain.Cars;

public class RaceService {
    private final NumberGenerator numberGenerator;

    public RaceService(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Cars generateCar(List<String> carNames) {
        return Cars.create(carNames);
    }

    public Cars moveCar(Cars cars) {
        return cars.movedAll(numberGenerator);
    }
}
