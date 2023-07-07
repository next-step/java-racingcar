package racing.domain;

import racing.generator.NumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class RacingManager {
    private CarCollection cars;
    private final NumberGenerator numberGenerator;

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
        int maxValue = cars.getCars().stream()
                .mapToInt(car -> car.getPosition().getPosition())
                .max()
                .orElse(-1);
        return cars.getCars().stream()
                .filter(car -> car.getPosition().getPosition() == maxValue)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
