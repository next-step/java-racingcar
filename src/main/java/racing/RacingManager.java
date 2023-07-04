package racing;

import racing.generator.NumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingManager {
    private List<Car> cars;
    private NumberGenerator numberGenerator;

    private int count;

    public RacingManager() {
    }

    public RacingManager(List<Car> cars, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.numberGenerator = numberGenerator;
    }

    public RacingManager(List<Car> cars, NumberGenerator numberGenerator, int count) {
        this(cars, numberGenerator);
        this.count = count;
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
        List<String> names = cars.stream().map(Car::getName).collect(Collectors.toList());
        List<List<Integer>> progress = new ArrayList<>();
        progress.add(cars.stream().map(Car::getPosition).collect(Collectors.toList()));
        for (int i = 0; i < this.count; i++) {
            nextStep();
            progress.add(cars.stream().map(Car::getPosition).collect(Collectors.toList()));
        }
        List<String> winners = getWinners().stream().map(Car::getName).collect(Collectors.toList());
        return new SimulationResult(names, progress, winners);
    }
}
