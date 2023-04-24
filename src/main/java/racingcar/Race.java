package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Race {
    private final Integer totalTryCount;
    private Integer currentTryCount = 0;
    private final List<Car> cars;

    public Race(List<Car> cars, Integer totalTryCount) {
        this.cars = cars;
        this.totalTryCount = totalTryCount;
    }

    public Race(String carNamesString, Integer totalTryCount, MoveStrategy moveStrategy) {
        this.cars = createCars(carNamesString.split(","), moveStrategy);
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

    private List<Car> createCars(String[] carNamesArray, MoveStrategy moveStrategy) {
        return Arrays.stream(carNamesArray)
                .map(carName -> new Car(carName, moveStrategy))
                .collect(Collectors.toList());
    }

    private void moveCars() {
        IntStream.range(0, this.cars.size())
                .forEach(i -> this.cars.get(i).move());
    }

    private Integer getMaxPosition() {
        return this.cars.stream()
                .mapToInt(car -> car.toDto().getPosition())
                .max()
                .orElseThrow(NoSuchElementException::new);
    }
}
