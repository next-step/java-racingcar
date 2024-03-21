package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Rounds;
import racingcar.domain.cars.Cars;
import racingcar.domain.movement.MovementStrategy;
import racingcar.vo.CarResult;
import racingcar.vo.GameResult;
import racingcar.vo.RoundResult;

public class Race {

    public GameResult progress(final Cars cars, final Rounds rounds, final MovementStrategy movementStrategy) {
        final List<RoundResult> roundResults = runAllRounds(cars, rounds, movementStrategy);
        final Cars winners = cars.winners();

        return new GameResult(roundResults, CarResult.fromCars(winners));
    }

    private List<RoundResult> runAllRounds(
            final Cars cars,
            final Rounds rounds,
            final MovementStrategy movementStrategy
    ) {
        return rounds.rounds()
                .stream()
                .map(round -> runSingleRound(round, cars, movementStrategy))
                .collect(Collectors.toUnmodifiableList());
    }

    private RoundResult runSingleRound(final int roundCount, final Cars cars, final MovementStrategy movementStrategy) {
        cars.moveForwardOrStop(movementStrategy);

        return new RoundResult(roundCount, CarResult.fromCars(cars));
    }
}
