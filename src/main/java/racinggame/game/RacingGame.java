package racinggame.game;

import racinggame.car.Car;
import racinggame.car.MoveStrategy;
import racinggame.exception.RacingGameException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static racinggame.exception.ErrorMessage.CAR_COUNT_REQUIREMENT_ERROR;
import static racinggame.exception.ErrorMessage.ROUNDS_REQUIREMENT_ERROR;

public class RacingGame {

    private final MoveStrategy moveStrategy;
    private final List<Car> cars;

    private static final int MINIMUM_CAR_COUNT = 2;
    private static final int MINIMUM_ROUNDS = 1;

    public RacingGame(int carCount, MoveStrategy moveStrategy) {
        validateCarCount(carCount);
        this.cars = createCars(carCount);
        this.moveStrategy = moveStrategy;
    }

    private void validateCarCount(int carCount) {
        if (carCount < MINIMUM_CAR_COUNT) {
            throw new RacingGameException(CAR_COUNT_REQUIREMENT_ERROR, MINIMUM_CAR_COUNT);
        }
    }

    private List<Car> createCars(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> new Car())
                .collect(Collectors.toList());
    }

    public void start(final int rounds) {
        validateRounds(rounds);
        for (var round = 0; round < rounds; round++) {
            playRound();
        }
    }

    private void validateRounds(final int rounds) {
        if (rounds < MINIMUM_ROUNDS) {
            throw new RacingGameException(ROUNDS_REQUIREMENT_ERROR, MINIMUM_ROUNDS);
        }
    }

    private void playRound() {
        for (final var car : cars) {
            car.move(moveStrategy);
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }

}
