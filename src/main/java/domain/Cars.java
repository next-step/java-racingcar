package domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(String[] carNames) {
        List<Car> newCars = new ArrayList<>();
        for (String carName : carNames) {
            newCars.add(new Car(carName));
        }
        this.cars = newCars;
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public List<RacingResult> race(int tryCount) {
        List<RacingResult> results = new ArrayList<>();
        for (int i = 1; i <= tryCount; i++) {
            race();
            results.add(new RacingResult(cars));
        }
        return results;
    }

    public void race() {
        for (Car racingCar : cars) {
            racingCar.move();
        }
    }

    public List<Car> getWinners() {
        Position maxPosition = getMaxPosition();

        return cars.stream()
            .filter(car -> car.getPosition().equals(maxPosition))
            .collect(Collectors.toList());
    }

    public Position getMaxPosition() {
        return cars.stream()
            .map(car -> car.getPosition())
            .sorted(Comparator.reverseOrder())
            .findFirst()
            .get();
    }
}
