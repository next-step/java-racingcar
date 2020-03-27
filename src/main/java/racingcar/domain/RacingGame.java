package racingcar.domain;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class RacingGame {

    private MoveStrategy moveStrategy;
    private List<String> carNames;
    private int tryCount;

    private List<Car> cars;

    public RacingGame(InputData inputData, MoveStrategy moveStrategy) {
        validate(inputData.getCarNames(), inputData.getTryCount());

        this.moveStrategy = moveStrategy;
        carNames = inputData.getCarNames();
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
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(toList());
    }

    private void validate(List<String> carNames, int tryCount) {
        validateCarNames(carNames);
        validateTryCount(tryCount);
    }

    private void validateCarNames(List<String> carNames) {
        if (carNames.size() < 1) {
            throw new IllegalArgumentException("입력 가능한 자동차 대수가 1보다 작을 수 없습니다.");
        }
    }

    private void validateTryCount(int tryCount) {
        if (tryCount < 1) {
            throw new IllegalArgumentException("입력 가능한 시도 횟수는 1보다 작을 수 없습니다.");
        }
    }
}
