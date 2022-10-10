package racingcar.domain;

import exception.NegativeNumberException;
import racingcar.dto.CarRecord;
import racingcar.dto.CarsRecord;
import racingcar.dto.RacingRecord;
import racingcar.strategy.MovingStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {
    private static final String CAR_NAME_NO_VALUE_MESSAGE = "자동차의 이름의 값이 없습니다.";

    private final int tryCount;
    private final Cars cars;
    private final RacingRecord racingRecord = new RacingRecord();

    public RacingCarGame(List<String> carNames, int tryCount) {
        validateCarNames(carNames);
        this.cars = new Cars(create(carNames));
        this.tryCount = tryCount;
    }

    private List<Car> create(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public RacingRecord play(MovingStrategy movingStrategy) {
        validatePositiveNumber(tryCount);
        for (int i = 0; i < tryCount; i++) {
            racingRecord.add(cars.move(movingStrategy));
        }
        return racingRecord;
    }

    public CarsRecord findFinalWinner() {
        List<CarRecord> records = cars.findWinners()
                .stream()
                .map(Car::generateRecord)
                .collect(Collectors.toList());
        return new CarsRecord(records);
    }

    private void validatePositiveNumber(int value) {
        if (value < 0) {
            throw new NegativeNumberException();
        }
    }

    private void validateCarNames(List<String> carNames) {
        if (isNullOrEmpty(carNames)) {
            throw new IllegalArgumentException(CAR_NAME_NO_VALUE_MESSAGE);
        }
    }

    private boolean isNullOrEmpty(List<String> carNames) {
        return carNames == null || carNames.isEmpty();
    }
}
