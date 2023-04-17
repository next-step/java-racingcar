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
    private Car[] cars;

    public Race(String carNamesString, Integer totalTryCount) {
        createCars(carNamesString.split(","));
        this.totalTryCount = totalTryCount;
    }

    public void continueRace(List<Integer> numbers) {
        moveCars(numbers);
        this.currentTryCount++;
    }

    public List<CarDto> toCarDtoList() {
        return Arrays.stream(this.cars)
                .map(Car::toDto)
                .collect(Collectors.toList());
    }

    public boolean isNotFinished() {
        return currentTryCount < totalTryCount;
    }

    public List<Integer> randomNumbers() {
        return IntStream.range(0, this.cars.length)
                .map(i -> this.randomNumber())
                .boxed()
                .collect(Collectors.toList());
    }

    private void createCars(String[] carNamesArray) {
        this.cars = Arrays.stream(carNamesArray)
                .map(Car::new)
                .toArray(Car[]::new);
    }

    private void moveCars(List<Integer> numbers) {
        IntStream.range(0, this.cars.length)
                .forEach(i -> this.cars[i].move(numbers.get(i)));
    }

    private Integer randomNumber() {
        return RANDOM.nextInt(MAX_NUMBER);
    }

    public List<Car> getFirstPlace() {
        Integer maxPosition = Arrays.stream(this.cars)
                .mapToInt(car -> car.toDto().getPosition())
                .max()
                .orElseThrow(NoSuchElementException::new);
        return Arrays.stream(this.cars)
                .filter(car -> car.toDto().getPosition().equals(maxPosition))
                .collect(Collectors.toList());
    }
}
