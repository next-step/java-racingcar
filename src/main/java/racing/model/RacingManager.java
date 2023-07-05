package racing.model;

import racing.exception.IllegalCountException;
import racing.exception.IllegalRandomNumberException;
import racing.generator.NumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingManager {
    private static final int MIN_MOVABLE = 4;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    private List<Car> cars;
    private NumberGenerator numberGenerator;
    private int count;

    public RacingManager(List<Car> cars, NumberGenerator numberGenerator, int count) {
        validateCount(count);
        this.cars = cars;
        this.numberGenerator = numberGenerator;
        this.count = count;
    }

    private void validateCount(int count) {
        if (count < 0) {
            throw new IllegalCountException();
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void nextStep() {
        for (Car car : cars) {
            randomlyGoForward(car);
        }
    }

    private void randomlyGoForward(Car car) {
        if (isMovable(numberGenerator.generate())) {
            car.goForward();
        }
    }

    private boolean isMovable(int value) {
        validateRandomNumber(value);
        return MIN_MOVABLE <= value;
    }

    private void validateRandomNumber(int value) {
        if (value < MIN_RANDOM_NUMBER || value > MAX_RANDOM_NUMBER) throw new IllegalRandomNumberException();
    }

    public List<Car> getWinners() {
        int maxValue = cars.stream().mapToInt(Car::getPosition).max().orElse(-1);
        return cars.stream().filter(car -> car.getPosition() == maxValue).collect(Collectors.toList());
    }

    public SimulationResult simulate() {
        List<List<CarVO>> progress = new ArrayList<>();

        progress.add(cars.stream().map(car -> new CarVO(car.getName(), car.getPosition())).collect(Collectors.toList()));
        for (int i = 0; i < this.count; i++) {
            nextStep();
            progress.add(cars.stream().map(car -> new CarVO(car.getName(), car.getPosition())).collect(Collectors.toList()));
        }
        List<String> winners = getWinners().stream().map(Car::getName).collect(Collectors.toList());
        return new SimulationResult(progress, winners);
    }
}
