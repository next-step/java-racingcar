package racingcar.domain;

import exception.NegativeNumberException;
import racingcar.dto.RacingRecord;
import racingcar.strategy.MovingStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {
    private static final String CAR_NAME_NULL_MESSAGE = "자동차의 이름의 값이 없습니다.";

    private final Cars cars;
    private final RacingRecord racingRecord = new RacingRecord();

    public RacingCarGame(List<String> carNames) {
        validateCarNames(carNames);
        this.cars = new Cars(create(carNames));
    }

    private List<Car> create(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public RacingRecord play(MovingStrategy movingStrategy, int tryCount) {
        validatePositiveNumber(tryCount);
        for (int i = 0; i < tryCount; i++) {
            racingRecord.add(cars.move(movingStrategy));
        }
        return racingRecord;
    }

    public List<Car> finish() {
        return cars.findWinners();
    }

    private void validatePositiveNumber(int value) {
        if (value < 0) {
            throw new NegativeNumberException();
        }
    }

    private void validateCarNames(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException(CAR_NAME_NULL_MESSAGE);
        }
    }
}
