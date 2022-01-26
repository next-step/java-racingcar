package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.movable.RandomForwardStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingService {

    private final Cars cars;

    private RacingService(final Cars cars) {
        this.cars = cars;
    }

    public static RacingService from(final Cars cars) {
        return new RacingService(cars);
    }

    public void drive() {
        IntStream.range(0, cars.getCars().size())
                .forEach(idx -> cars.getCars().get(idx).moveForward());
    }

    public List<Car> notifyCurrentStatement() {
        return cars.getCars();
    }

    public List<String> judgeWinners() {
        return cars.getCars().stream()
                .filter(car -> (car.getStep() == maxDriveLength() && car.getStep() > 0))
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }

    private int maxDriveLength() {
        return cars.getCars().stream()
                .mapToInt(Car::getStep)
                .max()
                .getAsInt();
    }

    public void registerCars(final List<String> splitUserInput) {
        for (String carName : splitUserInput) {
            cars.getCars().add(Car.of(carName, new RandomForwardStrategy()));
        }
    }

}
