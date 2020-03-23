package racingcar;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {

    private int numberOfCars;
    private int tryCount;

    private static Random randomGenerator;

    private List<Car> cars;

    public RacingGame(Random randomGenerator, InputData inputData) {
        this.randomGenerator = randomGenerator;
        validate(inputData.getNumberOfCars(), inputData.getTryCount());
        numberOfCars = inputData.getNumberOfCars();
        tryCount = inputData.getTryCount();
        generateCars();
    }

    public void progress() {
        cars.forEach(car -> car.move());
        tryCount -= 1;
    }

    public boolean isFinish() {
        return tryCount == 0;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    private void generateCars() {
        cars = IntStream
                .range(0, numberOfCars)
                .mapToObj(__ -> new Car(randomGenerator))
                .collect(Collectors.toList());
    }

    private void validate(int numberOfCars, int tryCount) {
        validateNumberOfCars(numberOfCars);
        validateTryCount(tryCount);
    }

    private void validateNumberOfCars(int numberOfCars) {
        if (numberOfCars < 1) {
            throw new IllegalArgumentException("입력 가능한 자동차 대수가 1보다 작을 수 없습니다.");
        }
    }

    private void validateTryCount(int tryCount) {
        if (tryCount < 1) {
            throw new IllegalArgumentException("입력 가능한 시도 횟수는 1보다 작을 수 없습니다.");
        }
    }
}
