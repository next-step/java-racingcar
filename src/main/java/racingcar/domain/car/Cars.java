package racingcar.domain.car;

import racingcar.domain.exception.InvalidCarCountException;
import racingcar.domain.strategy.RacingStrategy;
import racingcar.dto.RecordDto;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(List<Car> cars) {
        validateCarCount(cars.size());
        return new Cars(cars);
    }

    public static Cars ofNames(List<String> names) {
        validateCarCount(names.size());
        return names.stream()
                .map(Car::ofName)
                .collect(collectingAndThen(toList(), Cars::of));
    }

    private static void validateCarCount(int carCount) {
        if (carCount == 0) {
            throw new InvalidCarCountException();
        }
    }

    public void move(RacingStrategy racingStrategy) {
        cars.forEach(racingStrategy::move);
    }

    public List<RecordDto> getRecords() {
        return cars.stream()
                .map(Car::getRecord)
                .collect(toList());
    }

    public List<RecordDto> getWinnerRecord() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.isAt(maxPosition))
                .map(Car::getRecord)
                .collect(toList());
    }

    private Integer getMaxPosition() {
        return Collections.max(cars.stream()
                .map(Car::getPosition)
                .collect(toList()));
    }
}
