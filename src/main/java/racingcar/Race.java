package racingcar;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Race {
    private static final Integer MAX_NUMBER = 10;
    private static final Random RANDOM = new Random();

    private final Integer totalCarCount;
    private final Integer totalMoveCount;
    private Integer currentMoveCount = 0;
    private List<Car> cars;

    public Race(Integer totalCarCount, Integer totalMoveCount) {
        this.totalCarCount = totalCarCount;
        this.totalMoveCount = totalMoveCount;
    }

    public void continueRace() {
        moveCars();
        currentMoveCount++;
    }

    public void createCars() {
        this.cars = IntStream.range(0, totalCarCount)
                .mapToObj(i -> new Car())
                .collect(Collectors.toList());
    }

    public List<Integer> getCarsPositions() {
        return this.cars.stream().map(Car::getPosition).collect(Collectors.toList());
    }

    public boolean isNotFinished() {
        return currentMoveCount < totalMoveCount;
    }

    private void moveCars() {
        this.cars.forEach(car -> car.move(randomNumber()));
    }

    private Integer randomNumber() {
        return RANDOM.nextInt(MAX_NUMBER);
    }
}
