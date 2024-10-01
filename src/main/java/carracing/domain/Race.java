package carracing.domain;

import carracing.domain.random.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> cars = new ArrayList<>();
    private final RandomNumberGenerator randomNumberGenerator;

    private Race(List<Car> cars, RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.cars.addAll(cars);
    }

    public static Race of(List<String> carNames, RandomNumberGenerator randomNumberGenerator) {
        List<Car> cars = carNames.stream()
                .map(Car::of)
                .collect(Collectors.toList());
        return new Race(cars, randomNumberGenerator);
    }

    public void moveCars() {
        cars.forEach(car -> {
            int randomDistance = randomNumberGenerator.generate();
            car.move(randomDistance);
        });
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinners() {
        return cars.stream()
                .filter(car -> car.getPosition() == getMaxPosition())
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

}
