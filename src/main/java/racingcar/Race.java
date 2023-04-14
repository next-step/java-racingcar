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

    public void continueRace() {
        moveCars();
        currentTryCount++;
    }

    public List<Integer> getCarsPositions() {
        return this.cars
                .stream()
                .map(car -> car.toDto().getPosition())
                .collect(Collectors.toList());
    }

    public boolean isNotFinished() {
        return currentTryCount < totalTryCount;
    }

    private void createCars() {
        this.cars = IntStream.range(0, totalCarCount)
                .mapToObj(i -> new Car())
                .collect(Collectors.toList());
    }

    private void moveCars() {
        this.cars.forEach(car -> car.move(randomNumber()));
    }

    private Integer randomNumber() {
        return RANDOM.nextInt(MAX_NUMBER);
    }
}
