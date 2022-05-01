package racing.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import racing.exception.GameException;

public class RacingCars {
    private final List<Car> cars = new LinkedList<>();

    public RacingCars(List<String> names) {
        names.stream()
             .map(Car::new)
             .forEach(cars::add);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void run(GameRule gameRule) {
        cars.forEach(car -> car.run(gameRule));
    }

    public List<Car> findWinners() {
        Car forwardMostCar = findForwardMostCar().orElseThrow(() -> new GameException("가장 앞선 차를 찾지 못했습니다."));

        return cars.stream()
                   .filter(car -> car.isEqualLocation(forwardMostCar))
                   .collect(Collectors.toList());
    }

    public Optional<Car> findForwardMostCar() {
        return cars.stream()
                   .max(Car::compareLocation);
    }

    public int numberOfCars() {
        return cars.size();
    }
}
