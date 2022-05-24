package racing.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import racing.exception.GameException;

public class RacingCars {
    private static final int MIN_NUMBER_OF_PARTICIPANT = 1;
    private final List<Car> cars = new LinkedList<>();

    private RacingCars() {}

    public RacingCars(List<String> names) {
        if (names.size() < MIN_NUMBER_OF_PARTICIPANT) {
            throw new GameException("최소 참가자 수는 " + MIN_NUMBER_OF_PARTICIPANT + "개 이상이어야 합니다.");
        }

        names.stream()
             .map(Car::new)
             .forEach(cars::add);
    }

    public static RacingCars of(List<Car> cars) {
        final RacingCars racingCars = new RacingCars();
        racingCars.cars.addAll(cars);
        return racingCars;
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
