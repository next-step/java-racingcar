package racing;

import racing.generator.NumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class RacingManager {
    private List<Car> cars;
    private NumberGenerator numberGenerator;

    public RacingManager() {
    }

    public RacingManager(List<Car> cars, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.numberGenerator = numberGenerator;
    }

    public RacingManager(List<Car> cars, NumberGenerator numberGenerator, int i) {
        this.cars = cars;
        this.numberGenerator = numberGenerator;
    }

    public boolean isMovable(int value) {
        return 4 <= value && value <= 9;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void nextStep() {
        for (Car car : cars) {
            car.goForward(isMovable(numberGenerator.generate()));
        }
    }

    public List<Car> getWinners() {
        int maxValue = cars.stream().mapToInt(Car::getPosition).max().orElse(-1);
        return cars.stream().filter(car -> car.getPosition() == maxValue).collect(Collectors.toList());
    }

    public SimulationResult simulate() {
        return null;
    }
}
