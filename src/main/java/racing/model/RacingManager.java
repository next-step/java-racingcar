package racing.model;

import racing.domain.Car;
import racing.generator.NumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingManager {
    private static final int MOVING_RANGE_LOW = 4;
    private static final int MOVING_RANGE_HIGH = 9;


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
        for (Car car : this.cars) {
            car.goForward(isMovable(this.numberGenerator.generate()));
        }
    }

    public List<String> getWinners() {
        int maxValue = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(-1);
        return cars.stream()
                .filter(car -> car.getPosition() == maxValue)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
