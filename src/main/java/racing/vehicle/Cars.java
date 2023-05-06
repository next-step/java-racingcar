package racing.vehicle;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateCars(cars);
        this.cars = cars;
    }

    public Cars(CarNames carNames) {
        validateCarNames(carNames);
        cars = createRandomCars(carNames);
    }

    private void validateCarNames(CarNames carNames) {
        if (carNames == null || carNames.getSize() == 0) {
            throw new IllegalArgumentException("The number of participants must be positive.");
        }
    }

    private void validateCars(List<Car> cars) {
        if (cars.size() == 0) {
            throw new IllegalArgumentException("The number of participants must be positive.");
        }
    }

    private List<Car> createRandomCars(CarNames carNames) {
        return carNames.getNames().stream()
                .map(Car::createRandomCar)
                .collect(Collectors.toUnmodifiableList());
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public Cars getWinners() {
        int maxPosition = Collections.max(this.cars).getCurrentPosition();
        List<Car> winners = cars.stream()
                .filter(car -> car.isAt(maxPosition))
                .collect(Collectors.toUnmodifiableList());
        return new Cars(winners);
    }
}
