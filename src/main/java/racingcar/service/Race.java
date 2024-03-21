package racingcar.service;

import static racingcar.config.RacingCarException.PLAYING_COUNT_OUT_OF_RANGE;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import racingcar.domain.Cars;
import racingcar.domain.MovementStrategy;
import racingcar.vo.CarResult;
import racingcar.vo.GameResult;
import racingcar.vo.RoundResult;

public class Race {

    private static final int MINIMUM_PLAYING_COUNT = 1;
    private static final int START_ROUND = 1;

    public GameResult progress(final Cars cars, final int playingCount, final MovementStrategy movementStrategy) {
        validatePlayingCountIsInRange(playingCount);
        final List<RoundResult> roundResults = runAllRounds(cars, playingCount, movementStrategy);

        return new GameResult(roundResults, cars.winnerNames());
    }

    private static void validatePlayingCountIsInRange(final int playingCount) {
        if (isPlayingCountOutOfRange(playingCount)) {
            throw new IllegalArgumentException(PLAYING_COUNT_OUT_OF_RANGE.message(playingCount));
        }
    }

    private static boolean isPlayingCountOutOfRange(int playingCount) {
        return playingCount < MINIMUM_PLAYING_COUNT;
    }

    private List<RoundResult> runAllRounds(
            final Cars cars,
            final int playingCount,
            final MovementStrategy movementStrategy
    ) {
        return IntStream.range(START_ROUND, endRound(playingCount))
                .mapToObj(round -> runSingleRound(round, cars, movementStrategy))
                .collect(Collectors.toList());
    }

    private int endRound(final int playingCount) {
        return START_ROUND + playingCount;
    }

    private RoundResult runSingleRound(final int round, final Cars cars, final MovementStrategy movementStrategy) {
        cars.moveForwardOrStop(movementStrategy);

        return new RoundResult(round, CarResult.fromCars(cars));
    }
}
