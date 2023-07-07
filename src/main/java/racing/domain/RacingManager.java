package racing.domain;

import racing.generator.NumberGenerator;

import java.util.List;

public class RacingManager {
    private final NumberGenerator numberGenerator;
    private CarCollection cars;

    public RacingManager(List<Car> cars, NumberGenerator numberGenerator) {
        this.cars = new CarCollection(cars);
        this.numberGenerator = numberGenerator;
    }

    public List<Car> getCars() {
        return this.cars.getCars();
    }

    public void nextStep() {
        this.cars = this.cars.nextState(numberGenerator);
    }

    public List<String> getWinners() {
        return cars.getWinners();
    }
}
