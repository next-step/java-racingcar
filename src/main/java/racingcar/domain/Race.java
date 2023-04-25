package racingcar.domain;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Race {
    private final Integer totalTryCount;
    private Integer currentTryCount = 0;
    private final List<Car> cars;

    public Race(List<Car> cars, Integer totalTryCount) {
        this.cars = cars;
        this.totalTryCount = totalTryCount;
    }

    public Race(List<String> carNames, Integer totalTryCount, MoveStrategy moveStrategy) {
        this.cars = createCars(carNames, moveStrategy);
        this.totalTryCount = totalTryCount;
    }

    public void continueRace() {
        moveCars();
        this.currentTryCount++;
    }

    public List<CarDto> toCarDtoList() {
        return this.cars.stream()
                .map(Car::toDto)
                .collect(Collectors.toList());
    }

    public boolean isNotFinished() {
        return currentTryCount < totalTryCount;
    }

    public List<Car> getFirstPlace() {
        Integer maxPosition = getMaxPosition();
        return this.cars.stream()
                .filter(car -> car.isPositionEqual(maxPosition))
                .collect(Collectors.toList());
    }

    public String toString() {
        return this.cars.stream()
                .map(car -> car.toDto().getName())
                .collect(Collectors.joining(", "));
    }

    private List<Car> createCars(List<String> carNamesArray, MoveStrategy moveStrategy) {
        return carNamesArray.stream()
                .map(carName -> new Car(carName, moveStrategy))
                .collect(Collectors.toList());
    }

    private void moveCars() {
        cars.forEach(Car::move);
    }

    private Integer getMaxPosition() {
        return this.cars.stream()
                .mapToInt(car -> car.toDto().getPosition())
                .max()
                .orElseThrow(NoSuchElementException::new);
    }
}
