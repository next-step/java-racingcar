package racingcar.domain;

import exception.NegativeNumberException;
import racingcar.dto.CarsDto;
import racingcar.strategy.MovingStrategy;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private static final int ZERO = 0;

    private final Cars cars;
    private int tryCount;

    public RacingCarGame(Cars cars) {
        this.cars = cars;
    }

    public RacingCarGame(String carNames, int tryCount) {
        this.tryCount = validationPositiveNumber(tryCount);
        this.cars = new Cars(carNames);
    }

    public List<CarsDto> play(MovingStrategy movingStrategy) {
        List<CarsDto> carsValues = new ArrayList<>();
        for (int i = 0; i < tryCount; i++) {
            carsValues.add(new CarsDto(cars.move(movingStrategy)));
        }
        return carsValues;
    }

    private int validationPositiveNumber(int value) {
        if (value < ZERO) {
            throw new NegativeNumberException();
        }
        return value;
    }
}
