package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Race {
    private static final Integer MAX_NUMBER = 10;
    private static final Random RANDOM = new Random();

    private final Integer totalTryCount;
    private Integer currentTryCount = 0;
    private List<Car> cars;

    public Race(String carNamesString, Integer totalTryCount) {
        createCars(carNamesString.split(","));
        this.totalTryCount = totalTryCount;
    }

    public void continueRace(List<Integer> numbers) {
        moveCars(numbers);
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

    public List<Integer> randomNumbers() {
        return IntStream.range(0, this.cars.size())
                .map(i -> this.randomNumber())
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Car> getFirstPlace() {
        Integer maxPosition = getMaxPosition();
        return this.cars.stream()
                .filter(car -> car.isPositionEqual(maxPosition))
                .collect(Collectors.toList());
    }

    private void createCars(String[] carNamesArray) {
        this.cars = Arrays.stream(carNamesArray)
                .map(carName -> new Car(carName, new GreaterEqualThanStrategy()))
                .collect(Collectors.toList());
    }

    private void moveCars(List<Integer> numbers) {
        IntStream.range(0, this.cars.size())
                .forEach(i -> this.cars.get(i).move(numbers.get(i)));
    }

    private Integer randomNumber() {
        return RANDOM.nextInt(MAX_NUMBER);
    }

    private Integer getMaxPosition() {
        return this.cars.stream()
                .mapToInt(car -> car.toDto().getPosition())
                .max()
                .orElseThrow(NoSuchElementException::new);
    }
}
