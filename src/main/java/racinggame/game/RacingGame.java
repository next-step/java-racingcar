package racinggame.game;

import racinggame.car.Car;
import racinggame.exception.RacingGameException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static racinggame.exception.ErrorMessage.CAR_COUNT_REQUIREMENT_ERROR;
import static racinggame.exception.ErrorMessage.ROUND_REQUIREMENT_ERROR;

public class RacingGame {

    private static final int MINIMUM_CAR_COUNT = 2;
    private static final int MINIMUM_ROUND_COUNT = 1;

    private final int roundCount;
    private final List<Car> cars;

    public RacingGame(int carCount, int roundCount) {
        validateCarCount(carCount);
        validateRoundCount(roundCount);

        this.roundCount = roundCount;
        this.cars = IntStream.range(0, carCount)
                .mapToObj(i -> new Car())
                .collect(Collectors.toList());
    }

    private void validateCarCount(final int carCount) {
        if (carCount < MINIMUM_CAR_COUNT) {
            throw new RacingGameException(CAR_COUNT_REQUIREMENT_ERROR, MINIMUM_CAR_COUNT);
        }
    }

    private void validateRoundCount(final int roundCount) {
        if (roundCount < MINIMUM_ROUND_COUNT) {
            throw new RacingGameException(ROUND_REQUIREMENT_ERROR, MINIMUM_ROUND_COUNT);
        }
    }

    public List<Round> start() {
        return IntStream.range(0, roundCount)
                .mapToObj(i -> Round.start(cars))
                .collect(Collectors.toList());
    }

}
