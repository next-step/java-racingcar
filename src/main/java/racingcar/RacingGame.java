package racingcar;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class RacingGame {

    private MoveStrategy moveStrategy;
    private int numberOfCars;
    private int tryCount;

    private List<Car> cars;

    public RacingGame(InputData inputData, MoveStrategy moveStrategy) {
        validate(inputData.getNumberOfCars(), inputData.getTryCount());

        this.moveStrategy = moveStrategy;
        numberOfCars = inputData.getNumberOfCars();
        tryCount = inputData.getTryCount();

        generateCars();
    }

    public void progress() {
        for (Car c : cars) {
            c.move(moveStrategy.isMovable());
        }
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
                .mapToObj(__ -> new Car())
                .collect(toList());
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
