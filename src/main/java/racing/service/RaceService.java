package racing.service;

import racing.model.Cars;

public class RaceService {
    private final NumberGenerator numberGenerator;

    public RaceService(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Cars generateCar(int carCount) {
        return Cars.create(carCount, numberGenerator);
    }

    public Cars moveCar(Cars cars) {
        return cars.movedAll();
    }
}
