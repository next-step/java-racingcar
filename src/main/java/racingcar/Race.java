package racingcar;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Race {
    private static final Integer MAX_NUMBER = 10;
    private static final Random RANDOM = new Random();

    private final Integer totalCarCount;
    private final Integer totalTryCount;
    private Integer currentTryCount = 0;
    private List<Car> cars;

    public Race(Integer totalCarCount, Integer totalTryCount) {
        this.totalCarCount = totalCarCount;
        this.totalTryCount = totalTryCount;
        this.createCars();
    }

    public void continueRace(List<Integer> numbers) {
        moveCars(numbers);
        this.currentTryCount++;
    }

    public List<CarDto> toCarDtoList() {
        return this.cars
                .stream()
                .map(Car::toDto)
                .collect(Collectors.toList());
    }

    public boolean isNotFinished() {
        return currentTryCount < totalTryCount;
    }

    public List<Integer> randomNumbers() {
        return IntStream.range(0, this.totalCarCount)
                .map(i -> this.randomNumber())
                .boxed()
                .collect(Collectors.toList());
    }

    private void createCars() {
        this.cars = IntStream.range(0, this.totalCarCount)
                .mapToObj(i -> new Car())
                .collect(Collectors.toList());
    }

    private void moveCars(List<Integer> numbers) {
        IntStream.range(0, this.totalCarCount)
                .forEach(i -> this.cars.get(i).move(numbers.get(i)));
    }

    private Integer randomNumber() {
        return RANDOM.nextInt(MAX_NUMBER);
    }
}
